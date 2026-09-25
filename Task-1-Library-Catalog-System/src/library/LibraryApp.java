package library;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("===== Library Catalog System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. List Books");
            System.out.println("4. View Book Details");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {

                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Book ID.");
                        sc.nextLine();
                        break;
                    }

                    int bookId = sc.nextInt();
                    sc.nextLine();

                    if (bookId <= 0) {
                        System.out.println("Book ID must be greater than 0.");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    if (title.trim().isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    if (author.trim().isEmpty()) {
                        System.out.println("Author cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    if (category.trim().isEmpty()) {
                        System.out.println("Category cannot be empty.");
                        break;
                    }

                    Book book = new Book(bookId, title, author, category);
                    library.addBook(book);
                    break;
                }

                case 2: {

                    System.out.print("Enter title or author to search: ");
                    String keyword = sc.nextLine();

                    if (keyword.trim().isEmpty()) {
                        System.out.println("Search keyword cannot be empty.");
                        break;
                    }

                    library.searchBook(keyword);
                    break;
                }

                case 3: {
                    library.listBooks();
                    break;
                }

                case 4: {

                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Book ID.");
                        sc.nextLine();
                        break;
                    }

                    int bookId = sc.nextInt();
                    sc.nextLine();

                    if (bookId <= 0) {
                        System.out.println("Book ID must be greater than 0.");
                        break;
                    }

                    library.viewBookDetails(bookId);
                    break;
                }

                case 5: {

                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Book ID.");
                        sc.nextLine();
                        break;
                    }

                    int bookId = sc.nextInt();
                    sc.nextLine();

                    if (bookId <= 0) {
                        System.out.println("Book ID must be greater than 0.");
                        break;
                    }

                    library.removeBook(bookId);
                    break;
                }

                case 6: {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

}
