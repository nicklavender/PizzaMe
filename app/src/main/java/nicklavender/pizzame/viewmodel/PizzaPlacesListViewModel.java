/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

import nicklavender.pizzame.PizzaMeConstants;
import nicklavender.pizzame.adapter.PizzaPlacesAdapter;
import nicklavender.pizzame.api.queryresult.PizzaPlace;
import nicklavender.pizzame.model.PizzaPlaceModel;

public class PizzaPlacesListViewModel extends BaseObservable {

    private final static String TAG = PizzaPlacesListViewModel.class.getSimpleName();

    private final PizzaPlacesAdapter pizzaPlacesAdapter;
    private final List<PizzaPlaceModel> viewModelData;
    private final MutableLiveData<PizzaPlaceModel> selected;

    public PizzaPlacesListViewModel() {
        viewModelData = new ArrayList<>(PizzaMeConstants.PAGE_SIZE);
        pizzaPlacesAdapter = new PizzaPlacesAdapter(this, viewModelData);
        selected = new MutableLiveData<>();
    }

    @Bindable
    public PizzaPlacesAdapter getPizzaPlacesAdapter() {
        return this.pizzaPlacesAdapter;
    }

    @Bindable
    public List<PizzaPlaceModel> getViewModelData() {
        return this.viewModelData;
    }

    public void addPizzaPlaces(@NonNull List<PizzaPlace> pizzaPlaces) {
        Log.d(TAG, "addPizzaPlaces - adding: " + pizzaPlaces.size() + "pizza places");
        for(PizzaPlace pizzaPlace : pizzaPlaces) {
            viewModelData.add(new PizzaPlaceModel(pizzaPlace));
        }
        notifyPropertyChanged(BR.viewModelData);
    }

    void pizzaPlaceSelected(PizzaPlaceModel pizzaPlaceModel) {
        selected.setValue(pizzaPlaceModel);
    }

    public MutableLiveData<PizzaPlaceModel> getSelected() {
        return selected;
    }

}
