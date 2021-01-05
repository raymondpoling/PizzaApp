package org.mousehole.americanairline.myfourthapplication.model;

public class Pizza {

    private String pizzaFlavor;
    private double pizzaPrice;

    public Pizza(String pizzaFlavor, double pizzaPrice) {
        this.pizzaFlavor = pizzaFlavor;
        this.pizzaPrice = pizzaPrice;
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
}
