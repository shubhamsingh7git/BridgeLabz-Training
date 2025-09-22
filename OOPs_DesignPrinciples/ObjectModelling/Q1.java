package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.display();
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("OOP Principles", "Grady Booch");
        Book b3 = new Book("Data Structures", "Robert Lafore");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        lib1.showBooks();
        lib2.showBooks();
    }
}
