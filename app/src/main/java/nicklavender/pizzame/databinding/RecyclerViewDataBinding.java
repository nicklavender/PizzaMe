/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import nicklavender.pizzame.adapter.PizzaPlacesAdapter;
import nicklavender.pizzame.model.PizzaPlaceModel;

public class RecyclerViewDataBinding {
    /**
     * Binds the data to the {@link android.support.v7.widget.RecyclerView.Adapter}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView       passed in automatically with the data binding
     * @param pizzaPlacesAdapter must be explicitly passed in
     * @param data               must be explicitly passed in
     */
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, PizzaPlacesAdapter pizzaPlacesAdapter, List<PizzaPlaceModel> data) {
        recyclerView.setAdapter(pizzaPlacesAdapter);
        pizzaPlacesAdapter.updateData(data);
    }
}
