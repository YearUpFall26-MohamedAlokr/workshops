package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    static Scanner scanner = new Scanner(System.in);
    static void main(String[] args) {

         Book[] books = {
                 new Book(0, "9780020", "Charlotte's Web"),
                new Book(1, "9780001", "The Hobbit"),
                new Book(2, "9780002", "Harry Potter"),
                new Book(3, "9780003", "The Great Gatsby"),
                new Book(4, "9780004", "1984"),
                new Book(5, "9780005", "Pride and Prejudice"),
                new Book(6, "9780006", "Moby Dick"),
                new Book(7, "9780007", "The Odyssey"),
                new Book(8, "9780008", "To Kill a Mockingbird"),
                new Book(9, "9780009", "The Alchemist"),
                new Book(10, "9780010", "Fahrenheit 451"),
                new Book(11, "9780011", "Dune"),
                new Book(12, "9780012", "Dracula"),
                new Book(13, "9780013", "Frankenstein"),
                new Book(14, "9780014", "The Shining"),
                new Book(15, "9780015", "Jane Eyre"),
                new Book(16, "9780016", "The Catcher in the Rye"),
                new Book(17, "9780017", "Hamlet"),
                new Book(18, "9780018", "The Road"),
                new Book(19, "9780019", "The Lion, the Witch and the Wardrobe")

        };

        displayHomeScreen(books);
    }


    public static void displayHomeScreen(Book[] books){
        System.out.println("Enter 1 to Show Available Books");
        System.out.println("Enter 2 to Show Checked Out Books");
        System.out.println("Enter 3 to Exit");
        int choice=scanner.nextInt();
        boolean running=true;
        while (running) {
            switch (choice) {
                case 1:
                    showAvailableBooks(books);
                    break;
                case 2:
                    showCheckedOutBooks(books);
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    public static void showAvailableBooks(Book[] books){
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(
                       "Id: "+ book.getId()
                        +"   Isbn: " + book.getIsbn()
                        +"   Title: " +book.getTitle());
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("Enter 1 to select a book to check out");
        System.out.println("Enter 0 to exit");
        int choice=scanner.nextInt();
        boolean running=true;
        String name="";
        int bookId=0;
        while (running) {
            switch (choice) {
                case 1:
                    System.out.println("Enter your Name");
                    name=scanner.next();
                    System.out.println("Enter your Book ID");
                    bookId=scanner.nextInt();
                    books[bookId].checkOut(name);
                    displayHomeScreen(books);
                    break;
                case 0:
                    running = false;
                    displayHomeScreen(books);
                    break;
            }
        }

    }

    public static void showCheckedOutBooks(Book[] books){
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(
                                "Id: "+ book.getId()
                                +"   Isbn: " + book.getIsbn()
                                +"   Title: " +book.getTitle()
                                +"   Name of the person who has the book "+book.getCheckedOutTo());
            }

        }
        System.out.println("Enter C - to Check In a book");
        System.out.println("Enter X - to go back to the home screen ");
        char choice=scanner.next().charAt(0);
        boolean running=true;
        int bookId=0;
        while (running) {
            switch (choice) {
                case 'C':
                    System.out.println("Enter your Book ID");
                    bookId=scanner.nextInt();
                    books[bookId].checkIn();
                    displayHomeScreen(books);
                    break;
                case 'X':
                    running = false;
                    displayHomeScreen(books);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter C or X.");
                    break;
            }
        }
    }




}
