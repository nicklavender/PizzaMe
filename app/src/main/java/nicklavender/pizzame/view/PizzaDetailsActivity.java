/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import nicklavender.pizzame.PizzaMeConstants;
import nicklavender.pizzame.R;
import nicklavender.pizzame.databinding.ActivityPizzaPlaceDetailsBinding;
import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.utils.StringUtils;
import nicklavender.pizzame.viewmodel.PizzaPlaceDetailsViewModel;

public class PizzaDetailsActivity extends AppCompatActivity {

    private final static String TAG = PizzaDetailsActivity.class.getSimpleName();

    private PizzaPlaceDetailsViewModel pizzaPlaceDetailsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_place_details);
        bind();
        setUpPizzaDetailsListeners();
    }

    private void bind() {
        ActivityPizzaPlaceDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_pizza_place_details);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            PizzaPlaceModel pizzaPlaceModel = extras.getParcelable(PizzaMeConstants.PARCELABLE_PIZZA_PLACE_MODEL);
            pizzaPlaceDetailsViewModel = new PizzaPlaceDetailsViewModel(pizzaPlaceModel);
            binding.setPizzaPlaceDetailsViewModel(pizzaPlaceDetailsViewModel);
        }
    }

    private void setUpPizzaDetailsListeners() {
        if(pizzaPlaceDetailsViewModel != null) {
            pizzaPlaceDetailsViewModel.getPhoneNumberSelected().observe(this, this::onPhoneNumberSelected);
            pizzaPlaceDetailsViewModel.getWebsiteSelected().observe(this, this::onWebsiteSelected);
            pizzaPlaceDetailsViewModel.getGetDirectionsSelected().observe(this, this::onGetDirectionsSelected);
        }
    }

    private void onPhoneNumberSelected(String phoneNumber) {
        Log.d(TAG, "onPhoneNumberSelected: " + phoneNumber);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PizzaMeConstants.REQUEST_PERMISSIONS_LOCATIONS);
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private void onWebsiteSelected(String businessUrl) {
        Log.d(TAG, "onWebsiteSelected: " + businessUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(businessUrl));
        startActivity(intent);
    }

    private void onGetDirectionsSelected(PizzaPlaceModel pizzaPlaceModel) {
        Log.d(TAG, "onGetDirectionsSelected: " + pizzaPlaceModel);
        Uri gmmIntentUri = Uri.parse(StringUtils.getGeoSearchString(pizzaPlaceModel.getLatitude(), pizzaPlaceModel.getLongitude()) + Uri.encode(pizzaPlaceModel.getName()));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
