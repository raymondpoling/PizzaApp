package org.mousehole.americanairline.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import org.mousehole.americanairline.myfourthapplication.R;
import org.mousehole.americanairline.myfourthapplication.model.Pizza;
import org.mousehole.americanairline.myfourthapplication.util.Utilities;

public class DetailsActivity extends AppCompatActivity {

    private ImageView pizzaImageView;

    private TextView pizzaNameTextView,
            ingredientsTextView,
            priceTextView,
            imageUrlTextView,
            caloriesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // bindings
        pizzaImageView = findViewById(R.id.pizza_detail_imageview);
        pizzaNameTextView = findViewById(R.id.pizza_name_detail_textview);
        ingredientsTextView = findViewById(R.id.ingredients_textview);
        priceTextView = findViewById(R.id.detail_price_textview);
        imageUrlTextView = findViewById(R.id.image_url_textview);
        caloriesTextView = findViewById(R.id.calories_textview);

        Intent pizzaPassingIntent = getIntent();

        if(pizzaPassingIntent != null) {
            Pizza pizza = pizzaPassingIntent.getParcelableExtra(HomeActivity.PIZZA_DATA);
            pizzaNameTextView.setText(pizza.getPizzaFlavor());
            ingredientsTextView.setText(pizza.getIngredients());
            priceTextView.setText(Utilities.makePrice(pizza.getPizzaPrice()));
            imageUrlTextView.setText(pizza.getImageUrl());
            Log.e("TAGX", "calories text view is " + R.id.calories_textview);
            String calories = "Calories: " + pizza.getCalories();
            caloriesTextView.setText(calories);

            // Glide again
            Glide.with(this).load(pizza.getImageUrl()).into(pizzaImageView);

        }
    }
}