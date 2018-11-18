/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;
import android.util.Log;

import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.utils.StringUtils;

public class PizzaPlaceViewModel extends BaseObservable {

    private final String TAG = PizzaPlaceViewModel.class.getSimpleName();

    final PizzaPlaceModel pizzaPlace;
    @Nullable
    private final PizzaPlacesListViewModel pizzaPlacesListViewModel;

    public PizzaPlaceViewModel(PizzaPlaceModel pizzaPlacesModel, @Nullable PizzaPlacesListViewModel pizzaPlacesListViewModel) {
        this.pizzaPlace = pizzaPlacesModel;
        this.pizzaPlacesListViewModel = pizzaPlacesListViewModel;
    }

    @Bindable
    public String getName() {
        return StringUtils.getTitle(pizzaPlace.getName());
    }

    @Bindable
    public String getRating() {
        return StringUtils.getRating(pizzaPlace.getAverageRating());
    }

    @Bindable
    public String getAddress() {
        return pizzaPlace.getAddress();
    }

    @Bindable
    public String getPhoneNumber() {
        return pizzaPlace.getPhoneNumber();
    }

    @Bindable
    public String getRecentReview() {
        return pizzaPlace.getLastReviewIntro();
    }

    @Bindable
    public String getCityState() {
        return StringUtils.getCityState(pizzaPlace.getCity(), pizzaPlace.getState());
    }

    @Bindable
    public String getDistance() {
        return StringUtils.getDistance(pizzaPlace.getDistance());
    }

    public void onRestaurantClicked() {
        Log.d(TAG, "onRestaurantClicked: " + pizzaPlace.getName());
        if(pizzaPlacesListViewModel != null) {
            pizzaPlacesListViewModel.pizzaPlaceSelected(pizzaPlace);
        }
    }

}
