package org.mousehole.americanairline.myfourthapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pizza implements Parcelable {

    private String pizzaFlavor;
    private double pizzaPrice;

    private int calories;
    private String ingredients;
    private String imageUrl;

    public Pizza(String pizzaFlavor, double pizzaPrice, int calories, String ingredients, String imageUrl) {
        this.pizzaFlavor = pizzaFlavor;
        this.pizzaPrice = pizzaPrice;
        this.calories = calories;
        this.ingredients = ingredients;
        this.imageUrl = imageUrl;
    }

    protected Pizza(Parcel in) {
        pizzaFlavor = in.readString();
        pizzaPrice = in.readDouble();
        calories = in.readInt();
        ingredients = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPizzaFlavor() {
        return pizzaFlavor;
    }

    public void setPizzaFlavor(String pizzaFlavor) {
        this.pizzaFlavor = pizzaFlavor;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pizzaFlavor);
        parcel.writeDouble(pizzaPrice);
        parcel.writeInt(calories);
        parcel.writeString(ingredients);
        parcel.writeString(imageUrl);
    }
}
