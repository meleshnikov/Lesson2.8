package hw1;

import java.util.HashMap;
import java.util.Map;


public class ProductBasket {

    private final Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void add(Product product, int count) {
        products.put(product, count);
    }

    public void add(Product product) {
        products.put(product, 1);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
