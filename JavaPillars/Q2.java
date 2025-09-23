package JavaPillars;
import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double calculateDiscount();

   
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    private double warrantyFee;

    public Electronics(int productId, String name, double price, double warrantyFee) {
        super(productId, name, price);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty Fee: " + warrantyFee);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax() + " (" + getTaxDetails() + ")");
    }
}

class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }

    @Override
    public String getTaxDetails() {
        return "5% VAT applied";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: " + size);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax() + " (" + getTaxDetails() + ")");
    }
}

// Groceries product class
class Groceries extends Product {
    private double weight;

    public Groceries(int productId, String name, double price, double weight) {
        super(productId, name, price);
        this.weight = weight;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("No tax on groceries.");
    }
}

// Main class
public class Q2 {
    public static void printFinalPrices(List<Product> products) {
        for (Product product : products) {
            System.out.println(" ");
            product.displayDetails();

            double tax = 0;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }

            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product p1 = new Electronics(201, "Laptop", 60000, 2000);
        Product p2 = new Clothing(202, "T-Shirt", 1000, "L");
        Product p3 = new Groceries(203, "Rice", 2500, 10);

        products.add(p1);
        products.add(p2);
        products.add(p3);

        printFinalPrices(products);
    }
}
