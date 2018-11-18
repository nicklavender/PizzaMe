/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class PizzaPlace {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("xmlns")
    @Expose
    private String xmlns;

    @SerializedName("Title")
    @Expose
    private String name;

    @SerializedName("Address")
    @Expose
    private final String address;

    @SerializedName("City")
    @Expose
    private final String city;

    @SerializedName("State")
    @Expose
    private String state;

    @SerializedName("Phone")
    @Expose
    private String phoneNumber;

    @SerializedName("Latitude")
    @Expose
    private final String latitude;

    @SerializedName("Longitude")
    @Expose
    private final String longitude;

    @SerializedName("Rating")
    @Expose
    private final RestaurantRating rating;

    @SerializedName("Distance")
    @Expose
    private String distance;

    @SerializedName("Url")
    @Expose
    private final String yahooUrl;

    @SerializedName("ClickUrl")
    @Expose
    private final String clickUrl;

    @SerializedName("MapUrl")
    @Expose
    private final String mapUrl;

    @SerializedName("BusinessUrl")
    @Expose
    private final String businessUrl;

    @SerializedName("BusinessClickUrl")
    @Expose
    private final String businessClickUrl;

    @SerializedName("Categories")
    @Expose
    private final RestaurantCategories categories;

    @VisibleForTesting
    public PizzaPlace(String id, String xmlns, String name, String address, String city, String state, String phoneNumber, String latitude, String longitude, RestaurantRating rating,
                       String distance, String yahooUrl, String clickUrl, String mapUrl, String businessUrl, String businessClickUrl, RestaurantCategories categories) {
        this.id = id;
        this.xmlns = xmlns;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.distance = distance;
        this.yahooUrl = yahooUrl;
        this.clickUrl = clickUrl;
        this.mapUrl = mapUrl;
        this.businessUrl = businessUrl;
        this.businessClickUrl = businessClickUrl;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public RestaurantRating getRating() {
        return rating;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name " + name + " address: " + address + " city: " + city + " state: " + state + " phoneNumber: " + phoneNumber +
                " distance: " + distance + " yahooUrl: " + yahooUrl + " mapUrl: " + mapUrl + " businessUrl: " + businessUrl;
    }
}
