package Inheritance;
class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}


class Author extends Book {
    String name;
    String bio;

  
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); 
        this.name = name;
        this.bio = bio;
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class Q4 {
    public static void main(String[] args) {
        Author author = new Author(
            "The Great Adventure", 
            2021, 
            "John Smith", 
            "John Smith is a novelist specializing in adventure fiction."
        );
        author.displayInfo();
    }
}
