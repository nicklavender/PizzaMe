/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api;

import nicklavender.pizzame.PizzaMeConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAPI {

    private static PizzaPlaceApiService builder() {
        return new Retrofit.Builder()
                .baseUrl(PizzaMeConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PizzaPlaceApiService.class);
    }

    public static PizzaPlaceApiService pizzaPlaceApiService() {
        return builder();
    }
}
