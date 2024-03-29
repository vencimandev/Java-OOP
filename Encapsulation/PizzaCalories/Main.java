package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read pizza information
            String[] pizzaInfo = scanner.nextLine().split(" ");
            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));

            // Read dough information
            String[] doughInfo = scanner.nextLine().split(" ");
            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
            pizza.setDough(dough);

            // Read toppings information
            String line;
            while (!(line = scanner.nextLine()).equals("END")) {
                String[] toppingInfo = line.split(" ");
                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                pizza.addTopping(topping);
            }

            // Output the result
            System.out.println(pizza.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
