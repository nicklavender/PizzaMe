/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api;

import nicklavender.pizzame.api.queryresult.PizzaResponseTop;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PizzaPlaceApiService {

    @GET()
    Call<PizzaResponseTop> getPizzaPlaces(@Url String url);

    @GET()
    Call<PizzaResponseTop> getPizzaPlacesPage(@Url String url);

}
