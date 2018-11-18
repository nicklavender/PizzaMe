/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.api.queryresult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PizzaResponseTop {

    @SerializedName("query")
    @Expose
    private Query query;

    public Query getQuery() {
        return query;
    }


}
