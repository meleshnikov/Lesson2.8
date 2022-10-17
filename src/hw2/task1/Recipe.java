package hw2.task1;

import hw1.Product;

import java.util.Objects;
import java.util.Set;

public class Recipe {

    private final String name;

    private final Set<Product> products;

    private final double price;

    public Recipe(String name, Set<Product> products) {
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

        this.price = sum();
    }


    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
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

    private double sum() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}
