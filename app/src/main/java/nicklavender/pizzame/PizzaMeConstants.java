/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame;

public abstract class PizzaMeConstants {

    //Permissions
    public static final int REQUEST_PERMISSIONS_LOCATIONS = 1;

    //API constants
    public static final String BASE_URL = "https://query.yahooapis.com/v1/public/";
    public static final String DEFAULT_PIZZA_SEARCH = "yql?q=select%20*%20from%20local.search%20where%20zip%3D%27{zip}%27%20and%20query%3D%27pizza%27&format=json&diagnostics=false&callback=";
    public static final String PAGE_REPLACE_PIZZA_SEARCH = "yql?q=select%20*%20from%20local.search%28{offset}%2C{amount}%29%20where%20zip%3D%27{zip}%27%20and%20query%3D%27pizza%27&format=json&diagnostics=false&callback=";
    public static final int PAGE_SIZE = 10;

    //Parcelable Key
    public static final String PARCELABLE_PIZZA_PLACE_MODEL = "PARCELABLE_PIZZA_PLACE_MODEL";
}
