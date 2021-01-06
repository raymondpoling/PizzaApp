package org.mousehole.americanairline.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.mousehole.americanairline.myfourthapplication.R;
import org.mousehole.americanairline.myfourthapplication.model.Pizza;
import org.mousehole.americanairline.myfourthapplication.view.adapter.PizzaItemAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PizzaItemAdapter.PizzaDelegate {

    // image this was from a web service
    private Pizza supremePizza = new Pizza("Supreme",
            12.99,
            750,
            "Sausage, cheese, onion, diced peppers, mushrooms, pimento",
            "https://www.caseys.com/medias/sys_master/images/h47/h8b/8796496461854/8173_base-400x400/8173-base-400x400.png");
    private Pizza pepperoniPizza = new Pizza("Pepperoni",
            24.99,
            1000,
            "Pepperoni, sauce, cheese, garlic crust",
            "https://www.cookingclassy.com/wp-content/uploads/2014/07/pepperoni-pizza3+srgb..jpg");
    private Pizza chickenAlfredo = new Pizza("Chicken Alfredo",
            19.99,
            500,
            "Chicken, brocoli, alfredo sauce, cheese, mushrooms",
            "https://www.cookingclassy.com/wp-content/uploads/2012/12/chicken-alfredo-pizza11-srgb..jpg");

    private Pizza[] pizzaArray = {supremePizza, pepperoniPizza, chickenAlfredo};

    private List<Pizza> availablePizzas = Arrays.asList(pizzaArray);
    // End of mock data

    private ImageView pizzaImageView;

    private ListView pizzaView;
    private PizzaItemAdapter pizzaItemAdapter = new PizzaItemAdapter(availablePizzas, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindings
        pizzaView = findViewById(R.id.pizza_list_view);
    pizzaImageView = findViewById(R.id.pizza_imageview);


        pizzaView.setAdapter(pizzaItemAdapter);
    }

    @Override
    public void selectPizza(Pizza selected) {
        Toast.makeText(HomeActivity.this, selected.getPizzaFlavor(), Toast.LENGTH_SHORT).show();
        Glide.with(this).load(selected.getImageUrl()).into(pizzaImageView);
    }
}