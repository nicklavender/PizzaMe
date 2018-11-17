/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nicklavender.pizzame.R;
import nicklavender.pizzame.databinding.PizzaPlaceBinding;
import nicklavender.pizzame.model.PizzaPlaceModel;
import nicklavender.pizzame.viewmodel.PizzaPlaceViewModel;
import nicklavender.pizzame.viewmodel.PizzaPlacesListViewModel;

public class PizzaPlacesAdapter extends RecyclerView.Adapter<PizzaPlacesAdapter.PizzaPlaceViewHolder> {

    private final PizzaPlacesListViewModel pizzaPlacesListViewModel;
    private List<PizzaPlaceModel> adapterData;

    public PizzaPlacesAdapter(PizzaPlacesListViewModel pizzaPlacesListViewModel, List<PizzaPlaceModel> list) {
        this.pizzaPlacesListViewModel = pizzaPlacesListViewModel;
        this.adapterData = list;
    }

    @NonNull
    @Override
    public PizzaPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pizza_place, viewGroup, false);
        return new PizzaPlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaPlaceViewHolder pizzaPlaceViewHolder, int i) {
        PizzaPlaceModel pizzaPlacesModel = adapterData.get(i);
        pizzaPlaceViewHolder.setViewModel(new PizzaPlaceViewModel(pizzaPlacesModel, pizzaPlacesListViewModel));
    }

    @Override
    public void onViewAttachedToWindow(@NonNull PizzaPlaceViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull PizzaPlaceViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<PizzaPlaceModel> data) {
        if (data == null || data.isEmpty()) {
            this.adapterData.clear();
        } else {
            this.adapterData = data;
        }
    }

    @Override
    public int getItemCount() {
        return adapterData != null ? adapterData.size() : 0;
    }

    static class PizzaPlaceViewHolder extends RecyclerView.ViewHolder {
        PizzaPlaceBinding binding;

        PizzaPlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            bind();
        }

        void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        void setViewModel(PizzaPlaceViewModel viewModel) {
            if (binding != null) {
                binding.setPizzaPlaceViewModel(viewModel);
            }
        }


    }
}
