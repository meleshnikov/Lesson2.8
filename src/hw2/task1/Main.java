package hw2.task1;

import hw1.Product;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Product> products1 = new HashSet<>();
        Set<Product> products2 = new HashSet<>();

        products1.add(new Product("салат", 20, 0.05));
        products1.add(new Product("помидоры", 50, 0.3));
        products1.add(new Product("курица", 120, 0.5));
        products1.add(new Product("хлеб", 30, 0.2));

        products2.add(new Product("тесто", 20, 0.9));
        products2.add(new Product("сыр", 60, 0.3));


        Recipe recipe1 = new Recipe("Цезарь", products1);
        Recipe recipe2 = new Recipe("Пицца", products2);
        Recipe recipe3 = new Recipe("Пицца", products1);
        Recipe recipe4 = new Recipe("Цезарь", products2);

        Set<Recipe> recipes = new HashSet<>();
        add(recipes, recipe1);
        add(recipes, recipe2);
        add(recipes, recipe3);
        add(recipes, recipe4);

        System.out.println(recipes);

    }

    private static void add(Set<Recipe> recipes, Recipe recipe) {
        if (!recipes.add(recipe)) {
            throw new IllegalArgumentException(recipe.getName() + " уже есть в списке");
        }
    }
}
