import java.util.Scanner;

abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() {
        return title;
    }
}

class MyBook extends Book {
    @Override
    void setTitle(String s) {
        this.title = s;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read the input title
        String title = scanner.nextLine();

        // Create an instance of MyBook
        MyBook new_novel = new MyBook();

        // Set the title of the book
        new_novel.setTitle(title);

        // Print the title of the book
        System.out.println("The title is: " + new_novel.getTitle());

        // Close the scanner
        scanner.close();
    }
}
