package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    ArrayList<Product> products = new ArrayList<>();
    CustomerEcom customer;

    public Order(CustomerEcom customer) {
        this.customer = customer;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrder() {
        System.out.println("Order for customer: " + customer.name);
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.name + " : " + p.price);
            total += p.price;
        }
        System.out.println("Total: " + total);
    }
}

class CustomerEcom {
    String name;

    public CustomerEcom(String name) {
        this.name = name;
    }
}

public class Q7 {
    public static void main(String[] args) {
        CustomerEcom c1 = new CustomerEcom("Alice");
        Order o1 = new Order(c1);

        o1.addProduct(new Product("Laptop", 50000));
        o1.addProduct(new Product("Mouse", 500));

        o1.showOrder();
    }
}
