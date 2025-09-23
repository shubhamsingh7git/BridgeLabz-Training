package JavaPillars;
import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println(getDiscountDetails());
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 20;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + nonVegCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Extra Non-Veg Charge: " + nonVegCharge);
        System.out.println(getDiscountDetails());
    }
}

public class Q6 {
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            System.out.println("");
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
            }
            System.out.println("Total Price: " + total);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + (total - discount));
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));
        processOrder(order);
    }
}
