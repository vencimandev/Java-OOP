package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() >= this.numberOfToppings) {
            throw new IllegalArgumentException("Cannot add more toppings.");
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = this.dough.calculateCalories();
        for (Topping topping : this.toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
