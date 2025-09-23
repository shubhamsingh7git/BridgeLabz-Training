package JavaPillars;
import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null; 
    }
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected String getBorrower() { 
        return borrower;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    
    public abstract int getLoanDuration(); 

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}


class Book extends LibraryItem implements Reservable {
    private int pages;

    public Book(String itemId, String title, String author, int pages) {
        super(itemId, title, author);
        this.pages = pages;
    }

    @Override
    public int getLoanDuration() {
        return 21; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Pages: " + pages);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    private String issue;

    public Magazine(String itemId, String title, String author, String issue) {
        super(itemId, title, author);
        this.issue = issue;
    }

    @Override
    public int getLoanDuration() {
        return 7; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Issue: " + issue);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}


class DVD extends LibraryItem implements Reservable {
    private double duration;

    public DVD(String itemId, String title, String author, double duration) {
        super(itemId, title, author);
        this.duration = duration;
    }

    @Override
    public int getLoanDuration() {
        return 3; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved by " + getBorrower());
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

public class Q5 {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        LibraryItem b1 = new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald", 180);
        LibraryItem m1 = new Magazine("M202", "National Geographic", "John Smith", "June 2025");
        LibraryItem d1 = new DVD("D303", "Inception", "Christopher Nolan", 2.5);

        items.add(b1);
        items.add(m1);
        items.add(d1);

      
        for (LibraryItem item : items) {
            System.out.println(" ");
            item.getItemDetails();

            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                res.reserveItem("Alice");
                System.out.println("Availability: " + (res.checkAvailability() ? "Available" : "Not Available"));
            }
        }
    }
}
