package hw2.task1;

import hw1.Product;
import hw1.ProductBasket;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        ProductBasket products1 = new ProductBasket();
        ProductBasket products2 = new ProductBasket();

        products1.add(new Product("салат", 20, 0.05), 2);
        products1.add(new Product("помидоры", 50, 0.3), 5);
        products1.add(new Product("курица", 120, 0.5));
        products1.add(new Product("хлеб", 30, 0.2), 6);

        products2.add(new Product("тесто", 20, 0.9), 4);
        products2.add(new Product("сыр", 60, 0.3), 3);

        Recipe recipe1 = new Recipe("Цезарь", products1.getProducts());
        Recipe recipe2 = new Recipe("Пицца", products2.getProducts());

        System.out.println(recipe1);
        System.out.println(recipe2);
    }

    private static void add(Set<Recipe> recipes, Recipe recipe) {
        if (!recipes.add(recipe)) {
            throw new IllegalArgumentException(recipe.getName() + " уже есть в списке");
        }
    }
}
