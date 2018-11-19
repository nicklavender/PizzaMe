/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.utils;

import android.support.annotation.NonNull;

import nicklavender.pizzame.PizzaMeConstants;

public class StringUtils {

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
        return paged;
    }

    public static String getTitle(String title) {
        return StringUtils.isNullOrEmpty(title) ? "" : title;
    }

    public static String getRating(String rating) {
        return rating.equals("NaN") ? "No rating available" : rating + " stars";
    }

    public static String getCityState(String city, String state) {
        if (StringUtils.isNullOrEmpty(city) || StringUtils.isNullOrEmpty(state)) {
            if (city == null) {
                city = "";
            }
            if (state == null) {
                state = "";
            }
            return city + state;
        }
        return city + ", " + state;
    }

    public static String getDistance(String distance) {
        return StringUtils.isNullOrEmpty(distance) ? "" : distance + "mi.";
    }

    public static String getTotalRatings(String totalRatings) {
        return StringUtils.isNullOrEmpty(totalRatings) ? "" : totalRatings + " ratings";
    }

    public static String getGeoSearchString(@NonNull String latitude, @NonNull String longitude) {
        return "geo:" + latitude + "," + longitude + "?q=";
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

}
