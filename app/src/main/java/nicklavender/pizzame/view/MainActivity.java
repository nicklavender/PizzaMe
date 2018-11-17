/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import nicklavender.pizzame.PizzaMeConstants;
import nicklavender.pizzame.R;
import nicklavender.pizzame.api.PizzaAPI;
import nicklavender.pizzame.api.queryresult.PizzaPlace;
import nicklavender.pizzame.api.queryresult.PizzaResponseTop;
import nicklavender.pizzame.databinding.ActivityMainBinding;
import nicklavender.pizzame.databinding.AppDataBindingComponent;
import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.utilities.StringUtilities;
import nicklavender.pizzame.viewmodel.PizzaPlacesListViewModel;
import retrofit2.Call;
import retrofit2.Response;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private PizzaPlacesListViewModel pizzaPlacesListViewModel;
    private RecyclerView recyclerView;
    private boolean fetchingNextPage;
    private String zip;
    private TextView noPermissionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
        View view = bind();
        initRecyclerView(view);
        setUpPizzaPlaceSelectedListener();
        noPermissionsTextView = findViewById(R.id.no_permissions);
        getCurrentZipCode();
    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        pizzaPlacesListViewModel = new PizzaPlacesListViewModel();
        binding.setPizzaListModel(pizzaPlacesListViewModel);
        return binding.getRoot();
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.pizza_places_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
        recyclerView.addOnScrollListener(new RecyclerScrollListener());
    }

    private void getCurrentZipCode() {
        try {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PizzaMeConstants.REQUEST_PERMISSIONS_LOCATIONS);
                return;
            }
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            zip = addresses.get(0).getPostalCode();
            getPizzaPlaces();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, e.toString());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PizzaMeConstants.REQUEST_PERMISSIONS_LOCATIONS) {
            boolean permissionsGranted = true;
            for (int grantResult : grantResults) {
                permissionsGranted = permissionsGranted && grantResult == PackageManager.PERMISSION_GRANTED;
            }
            if (permissionsGranted) {
                noPermissionsTextView.setVisibility(View.GONE);
                getCurrentZipCode();
            } else {
                noPermissionsTextView.setVisibility(View.VISIBLE);
                noPermissionsTextView.setOnClickListener(v -> getCurrentZipCode());
            }
        }
    }

    private void setUpPizzaPlaceSelectedListener() {
        pizzaPlacesListViewModel.getSelected().observe(this, this::onPizzaPlaceSelected);
    }

    private void onPizzaPlaceSelected(PizzaPlaceModel pizzaPlaceModel) {
        Intent intent = new Intent(this, PizzaDetailsActivity.class);
        intent.putExtra(PizzaMeConstants.PARCELABLE_PIZZA_PLACE_MODEL, pizzaPlaceModel);
        startActivity(intent);
    }

    private void getPizzaPlaces() {
        Log.d(TAG, "getPizzaPlaces for zip: " + zip);
        PizzaAPI.pizzaPlaceApiService().getPizzaPlaces(StringUtilities.getDefaultApi(zip)).enqueue(new retrofit2.Callback<PizzaResponseTop>() {
            @Override
            public void onResponse(@NonNull Call<PizzaResponseTop> call, @NonNull Response<PizzaResponseTop> response) {
                if (response.isSuccessful()) {
                    PizzaResponseTop pizzaResponseTop = response.body();
                    List<PizzaPlace> pizzaPlaces = pizzaResponseTop != null ? pizzaResponseTop.getQuery().getResults().getResult() : null;
                    if (pizzaPlaces != null) {
                        addPage(pizzaPlaces);
                    }
                } else {
                    Log.d(TAG, "call not successful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<PizzaResponseTop> call, @NonNull Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void getMorePizzaPlaces() {
        int currentSize = pizzaPlacesListViewModel.getViewModelData().size();
        Log.d(TAG, "getMorePizzaPlaces currentSize: " + currentSize);
        PizzaAPI.pizzaPlaceApiService().getPizzaPlacesPage(StringUtilities.getPagedApi(zip, currentSize, PizzaMeConstants.PAGE_SIZE)).enqueue(new retrofit2.Callback<PizzaResponseTop>() {
            @Override
            public void onResponse(@NonNull Call<PizzaResponseTop> call, @NonNull Response<PizzaResponseTop> response) {
                if (response.isSuccessful()) {
                    PizzaResponseTop pizzaResponseTop = response.body();
                    List<PizzaPlace> pizzaPlaces = pizzaResponseTop != null ? pizzaResponseTop.getQuery().getResults().getResult() : null;
                    if (pizzaPlaces != null) {
                        addPage(pizzaPlaces);
                    }
                } else {
                    Log.d(TAG, "call not successful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<PizzaResponseTop> call, @NonNull Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void addPage(@NonNull List<PizzaPlace> pizzaPlaces) {
        Parcelable recyclerViewState;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        recyclerViewState = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
        Log.d(TAG, "getMorePizzaPlaces received: " + pizzaPlaces.size() + " new results");
        pizzaPlacesListViewModel.addPizzaPlaces(pizzaPlaces);
        if (recyclerViewState != null) {
            recyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);
        }
        fetchingNextPage = false;
    }

    class RecyclerScrollListener extends RecyclerView.OnScrollListener {

        RecyclerScrollListener() { }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            fetchNextPage(recyclerView);
        }

        private void fetchNextPage(@NonNull RecyclerView recyclerView) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager != null) {
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPos = linearLayoutManager.findFirstVisibleItemPosition();
                if (visibleItemCount + firstVisibleItemPos >= totalItemCount && !fetchingNextPage) {
                    fetchingNextPage = true;
                    getMorePizzaPlaces();
                }
            }
        }
    }

}
