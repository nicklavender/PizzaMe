/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame.databinding;


public class AppDataBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}
