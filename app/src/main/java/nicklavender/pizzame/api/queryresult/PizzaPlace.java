/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private String address;

    @SerializedName("City")
    @Expose
    private String city;

    @SerializedName("State")
    @Expose
    private String state;

    @SerializedName("Phone")
    @Expose
    private String phoneNumber;

    @SerializedName("Latitude")
    @Expose
    private String latitude;

    @SerializedName("Longitude")
    @Expose
    private String longitude;

    @SerializedName("Rating")
    @Expose
    private RestaurantRating rating;

    @SerializedName("Distance")
    @Expose
    private String distance;

    @SerializedName("Url")
    @Expose
    private String yahooUrl;

    @SerializedName("ClickUrl")
    @Expose
    private String clickUrl;

    @SerializedName("MapUrl")
    @Expose
    private String mapUrl;

    @SerializedName("BusinessUrl")
    @Expose
    private String businessUrl;

    @SerializedName("BusinessClickUrl")
    @Expose
    private String businessClickUrl;

    @SerializedName("Categories")
    @Expose
    private RestaurantCategories categories;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public RestaurantRating getRating() {
        return rating;
    }

    public void setRating(RestaurantRating rating) {
        this.rating = rating;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getYahooUrl() {
        return yahooUrl;
    }

    public void setYahooUrl(String yahooUrl) {
        this.yahooUrl = yahooUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    public void setBusinessUrl(String businessUrl) {
        this.businessUrl = businessUrl;
    }

    public String getBusinessClickUrl() {
        return businessClickUrl;
    }

    public void setBusinessClickUrl(String businessClickUrl) {
        this.businessClickUrl = businessClickUrl;
    }

    public RestaurantCategories getCategories() {
        return categories;
    }

    public void setCategories(RestaurantCategories categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name " + name + " address: " + address + " city: " + city + " state: " + state + " phoneNumber: " + phoneNumber +
                " distance: " + distance + " yahooUrl: " + yahooUrl + " mapUrl: " + mapUrl + " businessUrl: " + businessUrl;
    }
}
