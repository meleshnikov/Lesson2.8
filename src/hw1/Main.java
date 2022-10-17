package hw1;

public class Main {
    public static void main(String[] args) {
        ProductSet products = new ProductSet();

        Product potato = new Product("картофель", 40.5, 6);
        Product milk = new Product("молоко", 56, 0.5);
        Product meat = new Product("мясо", 593, 3);

        products.add(potato);
        products.add(milk);
        products.add(meat);

        System.out.println(products);

        products.getProducts().remove(milk);
        System.out.println(products);

        products.check(meat);
        products.check(milk);
        products.check(potato);

        products.add(potato);
    }
}
