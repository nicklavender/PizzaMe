/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantRating {

    @SerializedName("AverageRating")
    @Expose
    private String averageRating;
    @SerializedName("TotalRatings")
    @Expose
    private String totalRatings;
    @SerializedName("TotalReviews")
    @Expose
    private String totalReviews;
    @SerializedName("LastReviewDate")
    @Expose
    private String lastReviewDate;
    @SerializedName("LastReviewIntro")
    @Expose
    private String lastReviewIntro;

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(String totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(String totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(String lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public String getLastReviewIntro() {
        return lastReviewIntro;
    }

    public void setLastReviewIntro(String lastReviewIntro) {
        this.lastReviewIntro = lastReviewIntro;
    }
}
