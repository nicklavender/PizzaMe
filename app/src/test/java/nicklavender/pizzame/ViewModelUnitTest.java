/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import nicklavender.pizzame.api.queryresult.PizzaPlace;
import nicklavender.pizzame.api.queryresult.RestaurantCategories;
import nicklavender.pizzame.api.queryresult.RestaurantRating;
import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.viewmodel.PizzaPlaceDetailsViewModel;
import nicklavender.pizzame.viewmodel.PizzaPlaceViewModel;
import nicklavender.pizzame.viewmodel.PizzaPlacesListViewModel;

public class ViewModelUnitTest {

    private PizzaPlaceViewModel pizzaPlaceViewModel;
    private PizzaPlacesListViewModel pizzaPlacesListViewModel;
    private PizzaPlaceDetailsViewModel pizzaPlaceDetailsViewModel;

    @Before
    public void init() {
        RestaurantRating restaurantRating = new RestaurantRating("3.5", "20", "10", "11172018", "Pizza Test Name restaurant was great!");
        RestaurantCategories restaurantCategories = new RestaurantCategories("restaurantCategoriesId", "Pizza");
        PizzaPlaceModel pizzaPlaceModel = new PizzaPlaceModel(new PizzaPlace("id", "xmlns", "Pizza Test Name", "1000 Test Lane", "TestCity", "TestState", "555-555-5555",
                "30", "-30", restaurantRating, "5.0", "www.yahooUrl.com", "www.clickUrl.com", "www.mapUrl.com", "www.businessUrl.com",
                "www.businessClickUrl.com", restaurantCategories));
        pizzaPlacesListViewModel = new PizzaPlacesListViewModel();
        pizzaPlaceViewModel = new PizzaPlaceViewModel(pizzaPlaceModel, pizzaPlacesListViewModel);
        pizzaPlaceDetailsViewModel = new PizzaPlaceDetailsViewModel(pizzaPlaceModel);
    }

    @Test
    public void test_pizza_place_view_model_getters() {
        assertEquals("Pizza Test Name", pizzaPlaceViewModel.getName());
        assertEquals("1000 Test Lane", pizzaPlaceViewModel.getAddress());
        assertEquals("TestCity, TestState", pizzaPlaceViewModel.getCityState());
        assertEquals("5.0mi.", pizzaPlaceViewModel.getDistance());
        assertEquals("555-555-5555", pizzaPlaceViewModel.getPhoneNumber());
        assertEquals("3.5 stars", pizzaPlaceViewModel.getRating());
        assertEquals("Pizza Test Name restaurant was great!", pizzaPlaceViewModel.getRecentReview());
    }

    @Test
    public void test_pizza_place_list_view_model_getters() {
        assertTrue(pizzaPlacesListViewModel.getViewModelData().isEmpty());
    }

    @Test
    public void test_pizza_place_details_view_model_getters() {
        //Inherited getters
        assertEquals("Pizza Test Name", pizzaPlaceDetailsViewModel.getName());
        assertEquals("1000 Test Lane", pizzaPlaceDetailsViewModel.getAddress());
        assertEquals("TestCity, TestState", pizzaPlaceDetailsViewModel.getCityState());
        assertEquals("5.0mi.", pizzaPlaceDetailsViewModel.getDistance());
        assertEquals("555-555-5555", pizzaPlaceDetailsViewModel.getPhoneNumber());
        assertEquals("3.5 stars", pizzaPlaceDetailsViewModel.getRating());
        assertEquals("Pizza Test Name restaurant was great!", pizzaPlaceDetailsViewModel.getRecentReview());
        //PizzaPlaceDetailsViewModel only getters
        assertEquals("20 ratings", pizzaPlaceDetailsViewModel.getTotalRatings());

    }

}
