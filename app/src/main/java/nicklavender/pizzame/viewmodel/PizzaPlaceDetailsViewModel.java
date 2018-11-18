/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.databinding.Bindable;
import android.util.Log;

import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.utils.StringUtils;

public class PizzaPlaceDetailsViewModel extends PizzaPlaceViewModel {

    private static final String TAG = PizzaPlaceDetailsViewModel.class.getSimpleName();


    private final MutableLiveData<String> phoneNumberSelected;
    private final MutableLiveData<String> websiteSelected;
    private final MutableLiveData<PizzaPlaceModel> getDirectionsSelected;

    public PizzaPlaceDetailsViewModel(PizzaPlaceModel pizzaPlaceModel) {
        super(pizzaPlaceModel, null);
        phoneNumberSelected = new MutableLiveData<>();
        websiteSelected = new MutableLiveData<>();
        getDirectionsSelected = new MutableLiveData<>();

    }

    @Bindable
    public String getTotalRatings() {
        return StringUtils.getTotalRatings(pizzaPlace.getTotalRatings());
    }

    public void onPhoneNumberClicked() {
        Log.d(TAG, "onPhoneNumberClicked");
        phoneNumberSelected.setValue(getPhoneNumber());
    }

    public void onWebsiteClicked() {
        Log.d(TAG, "onWebsiteClicked");
        websiteSelected.setValue(pizzaPlace.getBusinessUrl());
    }

    public void onGetDirectionsClicked() {
        Log.d(TAG, "onGetDirectionsClicked");
        getDirectionsSelected.setValue(pizzaPlace);
    }

    public MutableLiveData<String> getPhoneNumberSelected() {
        return phoneNumberSelected;
    }

    public MutableLiveData<String> getWebsiteSelected() {
        return websiteSelected;
    }

    public MutableLiveData<PizzaPlaceModel> getGetDirectionsSelected() {
        return getDirectionsSelected;
    }
}
