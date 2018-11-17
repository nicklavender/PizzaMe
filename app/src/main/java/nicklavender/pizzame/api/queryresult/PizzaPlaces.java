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
    private List<PizzaPlace> result = null;

    public List<PizzaPlace> getResult() {
        return result;
    }

    public void setResult(List<PizzaPlace> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public String toString() {
        return "PizzaPlaces: count: " + result.size();
    }

}
