/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame;

import org.junit.Before;
import org.junit.Test;

import nicklavender.pizzame.api.queryresult.PizzaPlace;
import nicklavender.pizzame.api.queryresult.RestaurantCategories;
import nicklavender.pizzame.api.queryresult.RestaurantRating;
import nicklavender.pizzame.model.PizzaPlaceModel;

import static org.junit.Assert.assertEquals;

public class ModelUnitTest {

    private PizzaPlaceModel pizzaPlaceModel;

    @Before
    public void init() {
        RestaurantRating restaurantRating = new RestaurantRating("3.5", "20", "10", "11172018", "Pizza Test Name restaurant was great!");
        RestaurantCategories restaurantCategories = new RestaurantCategories("restaurantCategoriesId", "Pizza");
        pizzaPlaceModel = new PizzaPlaceModel(new PizzaPlace("id", "xmlns", "Pizza Test Name", "1000 Test Lane", "TestCity", "TestState", "555-555-5555",
                "30", "-30", restaurantRating, "5.0", "www.yahooUrl.com", "www.clickUrl.com", "www.mapUrl.com", "www.businessUrl.com",
                "www.businessClickUrl.com", restaurantCategories));
    }

    @Test
    public void test_pizza_place_model_getters() {
        assertEquals("Pizza Test Name", pizzaPlaceModel.getName());
        assertEquals("1000 Test Lane", pizzaPlaceModel.getAddress());
        assertEquals("TestCity", pizzaPlaceModel.getCity());
        assertEquals("TestState", pizzaPlaceModel.getState());
        assertEquals("555-555-5555", pizzaPlaceModel.getPhoneNumber());
        assertEquals("30", pizzaPlaceModel.getLatitude());
        assertEquals("-30", pizzaPlaceModel.getLongitude());
        assertEquals("3.5", pizzaPlaceModel.getAverageRating());
        assertEquals("20", pizzaPlaceModel.getTotalRatings());
        assertEquals("10", pizzaPlaceModel.getTotalReviews());
        assertEquals("11172018", pizzaPlaceModel.getLastReviewDate());
        assertEquals("Pizza Test Name restaurant was great!", pizzaPlaceModel.getLastReviewIntro());
        assertEquals("5.0", pizzaPlaceModel.getDistance());
        assertEquals("www.mapUrl.com", pizzaPlaceModel.getMapUrl());
        assertEquals("www.businessUrl.com", pizzaPlaceModel.getBusinessUrl());
    }
}
