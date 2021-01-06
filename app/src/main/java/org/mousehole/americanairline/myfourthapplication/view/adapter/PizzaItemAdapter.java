package org.mousehole.americanairline.myfourthapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.mousehole.americanairline.myfourthapplication.R;
import org.mousehole.americanairline.myfourthapplication.model.Pizza;

import java.util.List;

public class PizzaItemAdapter extends BaseAdapter {

    private final List<Pizza> availablePizzas;
    private PizzaDelegate pizzaDelegate;

    public interface PizzaDelegate {
        void selectPizza(Pizza selected);
    }

    public PizzaItemAdapter(List<Pizza> availablePizzas, PizzaDelegate pizzaDelegate) {
        this.availablePizzas = availablePizzas;
        this.pizzaDelegate = pizzaDelegate;
    }

    @Override
    public int getCount() {
        return availablePizzas.size();
    }

    @Override
    public Pizza getItem(int i) {
        return availablePizzas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long)i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { // this is where we inflate view
        Pizza item = availablePizzas.get(i);

        View mainView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pizza_flavor_layout_item,
                        viewGroup,
                        false);

        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizzaDelegate.selectPizza(item);
            }
        });

        TextView pizzaFlavor = mainView.findViewById(R.id.pizza_textview);
        TextView pizzaPrice = mainView.findViewById(R.id.pizza_price_textview);

        pizzaFlavor.setText(item.getPizzaFlavor());
        pizzaPrice.setText("$" + item.getPizzaPrice());

        return mainView;
    }
}
