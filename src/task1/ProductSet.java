package task1;

import java.util.HashSet;
import java.util.Set;

public class ProductSet {

    private final Set<Product> products;

    public ProductSet() {
        products = new HashSet<>();
    }

    public void add(Product product) {
        if (!products.add(product)) {
            throw new IllegalArgumentException(product.getName() + " уже есть в списке");
        }
    }

    public void check(Product product) {
        System.out.println(product.getName() + " есть в списке? - " + (products.contains(product) ? "да" : "нет"));
    }

    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
