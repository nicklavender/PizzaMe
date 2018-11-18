/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PizzaPlaces {

    @SerializedName("Result")
    @Expose
    private final List<PizzaPlace> result = null;

    public List<PizzaPlace> getResult() {
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        int count = result == null ? 0 : result.size();
        return "PizzaPlaces: count: " + result.size();
    }

}
