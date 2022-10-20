package hw2.task1;

import hw1.Product;

import java.util.Map;
import java.util.Objects;

public class Recipe {

    private final String name;

    private final Map<Product, Integer> products;

    private final double price;

    public Recipe(String name, Map<Product, Integer> products) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("invalid recipe's name");
        }
        if (products != null && !products.isEmpty()) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("products not found");
        }
        this.price = sumPrice();
    }


    public String getName() {
        return name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Рецепт - %s (Стоимость - %.1f руб)\nСостав: ", getName(), getPrice())
                + getProducts() + "\n";
    }

    private double sumPrice() {
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getKey().getWeight() * entry.getValue();
        }
        return sum;
    }
}
