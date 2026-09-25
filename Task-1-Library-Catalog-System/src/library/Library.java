package library;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books=new ArrayList<>();

    public void addBook(Book book){
          for(Book existingBook:books){
              if(existingBook.getBookId()==book.getBookId()) {
                  System.out.println("Book Id already exists");
                  return;
              }
        }
          books.add(book);
          System.out.println("Book added successfully");
    }
    public void listBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Category: " + book.getCategory());
        }
    }
    public void searchBook(String keyword) {

        boolean found = false;

        keyword = keyword.toLowerCase();

        for (Book book : books) {

            if (book.getTitle().toLowerCase().contains(keyword)
                    || book.getAuthor().toLowerCase().contains(keyword)) {

                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Category: " + book.getCategory());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found");
        }
    }
    public void viewBookDetails(int bookId) {
        boolean found = false;

        for (Book existingBook : books) {
            if (existingBook.getBookId() == bookId) {
                System.out.println("Book ID: " + existingBook.getBookId());
                System.out.println("Title: " + existingBook.getTitle());
                System.out.println("Author: " + existingBook.getAuthor());
                System.out.println("Category: " + existingBook.getCategory());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }
    public void removeBook(int bookId) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getBookId() == bookId) {

                books.remove(i);
                System.out.println("Book removed successfully");
                return;
            }
        }

        System.out.println("Book not found");
    }
}
