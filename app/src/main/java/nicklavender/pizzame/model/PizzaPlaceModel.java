/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.model;


import android.os.Parcel;
import android.os.Parcelable;

import nicklavender.pizzame.api.queryresult.PizzaPlace;

public class PizzaPlaceModel implements Parcelable {

    private final String name;
    private final String address;
    private final String city;
    private final String state;
    private final String phoneNumber;
    private final String latitude;
    private final String longitude;
    private final String averageRating;
    private final String totalRatings;
    private final String totalReviews;
    private final String lastReviewDate;
    private final String lastReviewIntro;
    private final String distance;
    private final String mapUrl;
    private final String businessUrl;


    public PizzaPlaceModel(PizzaPlace pizzaPlace) {
        this.name = pizzaPlace.getTitle();
        this.address = pizzaPlace.getAddress();
        this.city = pizzaPlace.getCity();
        this.state = pizzaPlace.getState();
        this.phoneNumber = pizzaPlace.getPhone();
        this.latitude = pizzaPlace.getLatitude();
        this.longitude = pizzaPlace.getLongitude();
        this.averageRating = pizzaPlace.getRating().getAverageRating();
        this.totalRatings = pizzaPlace.getRating().getTotalRatings();
        this.totalReviews = pizzaPlace.getRating().getTotalReviews();
        this.lastReviewDate = pizzaPlace.getRating().getLastReviewDate();
        this.lastReviewIntro = pizzaPlace.getRating().getLastReviewIntro();
        this.distance = pizzaPlace.getDistance();
        this.mapUrl = pizzaPlace.getMapUrl();
        this.businessUrl = pizzaPlace.getBusinessUrl();

    }

    public String getName() {
        return name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getTotalRatings() {
        return totalRatings;
    }

    public String getTotalReviews() {
        return totalReviews;
    }

    public String getLastReviewDate() {
        return lastReviewDate;
    }

    public String getLastReviewIntro() {
        return lastReviewIntro;
    }

    public String getDistance() {
        return distance;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    private PizzaPlaceModel(Parcel in) {
        name = in.readString();
        address = in.readString();
        city = in.readString();
        state = in.readString();
        phoneNumber = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        averageRating = in.readString();
        totalRatings = in.readString();
        totalReviews = in.readString();
        lastReviewDate = in.readString();
        lastReviewIntro = in.readString();
        distance = in.readString();
        mapUrl = in.readString();
        businessUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(phoneNumber);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(averageRating);
        dest.writeString(totalRatings);
        dest.writeString(totalReviews);
        dest.writeString(lastReviewDate);
        dest.writeString(lastReviewIntro);
        dest.writeString(distance);
        dest.writeString(mapUrl);
        dest.writeString(businessUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PizzaPlaceModel> CREATOR = new Parcelable.Creator<PizzaPlaceModel>() {
        @Override
        public PizzaPlaceModel createFromParcel(Parcel in) {
            return new PizzaPlaceModel(in);
        }

        @Override
        public PizzaPlaceModel[] newArray(int size) {
            return new PizzaPlaceModel[size];
        }
    };
}