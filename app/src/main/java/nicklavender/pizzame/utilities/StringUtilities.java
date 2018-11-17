/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.utilities;

import android.text.TextUtils;
import android.util.Log;

import nicklavender.pizzame.PizzaMeConstants;

public class StringUtilities {

    private final static String TAG = StringUtilities.class.getSimpleName();

    public static String getDefaultApi(String zip) {
        String firstPage = PizzaMeConstants.DEFAULT_PIZZA_SEARCH;
        firstPage = firstPage.replace("{zip}", zip);
        return firstPage;
    }

    public static String getPagedApi(String zip, int offset, int amount) {
        String paged = PizzaMeConstants.PAGE_REPLACE_PIZZA_SEARCH;
        paged = paged.replace("{offset}", String.valueOf(offset));
        paged = paged.replace("{amount}", String.valueOf(amount));
        paged = paged.replace("{zip}", zip);
        Log.d(TAG, "getPagedApi offset: " + offset + " amount: " + amount + " full: " + paged);
        return paged;
    }

    public static String getTitle(String title) {
        return !TextUtils.isEmpty(title) ? title : "";
    }

    public static String getRating(String rating) {
        return rating.equals("NaN") ? "No rating available" : rating + " stars";
    }

    public static String getCityState(String city, String state) {
        if (TextUtils.isEmpty(city) || TextUtils.isEmpty(state)) {
            return city + state;
        }
        return city + " ," + state;
    }

    public static String getDistance(String distance) {
        return TextUtils.isEmpty(distance) ? "" : distance + "mi.";
    }

    public static String getTotalRatings(String totalRatings) {
        return TextUtils.isEmpty(totalRatings) ? "" : totalRatings + " ratings";
    }

    public static String getGeoSearchString(String latitude, String longitude) {
        return "geo:" + latitude + "," + longitude + "?q=";
    }
}
