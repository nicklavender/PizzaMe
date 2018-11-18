/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantRating {

    @SerializedName("AverageRating")
    @Expose
    private final String averageRating;
    @SerializedName("TotalRatings")
    @Expose
    private final String totalRatings;
    @SerializedName("TotalReviews")
    @Expose
    private final String totalReviews;
    @SerializedName("LastReviewDate")
    @Expose
    private final String lastReviewDate;
    @SerializedName("LastReviewIntro")
    @Expose
    private final String lastReviewIntro;

    @VisibleForTesting
    public RestaurantRating(String averageRating, String totalRatings, String totalReviews, String lastReviewDate, String lastReviewIntro) {
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.totalReviews = totalReviews;
        this.lastReviewDate = lastReviewDate;
        this.lastReviewIntro = lastReviewIntro;
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
}
