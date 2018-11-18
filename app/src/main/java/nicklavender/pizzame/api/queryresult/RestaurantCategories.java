/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RestaurantCategories {

    @SerializedName("id")
    @Expose
    private final String id;
    @SerializedName("content")
    @Expose
    private final String content;

    @VisibleForTesting
    public RestaurantCategories(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
