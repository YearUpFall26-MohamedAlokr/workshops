package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;


public class OnlineStore {
    static ArrayList<Product> inventory = new ArrayList<Product>();
    static ArrayList<Product> cart = new ArrayList<Product>();
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        load();
        UI();
    }

    public static void load() {
        try {
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            bufReader.readLine();
            while ((input = bufReader.readLine()) != null) {
                String SKU = input.split("\\|")[0];
                String ProductName = input.split("\\|")[1];
                double Price = Double.parseDouble(input.split("\\|")[2]);
                String Department = input.split("\\|")[3];
                Product p = new Product(SKU, ProductName, Price, Department);
                inventory.add(p);
            }
            bufReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UI() {
        boolean running = true;
        while (running) {
            System.out.println("What do you want to do?");
            System.out.println("1- Display all products");
            System.out.println("2- Display Cart ");
            System.out.println("3- Exit the application");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    DisplayProducts();
                    boolean running2 = true;
                    while (running2) {
                    System.out.println("What do you want to do?");
                    System.out.println("1- Search Product By name");
                    System.out.println("2- Search product By Price Range");
                    System.out.println("3- Search product By Department Name");
                    System.out.println("4- Add a Product To You Cart");
                    System.out.println("5- Exit to main Menu");
                    int choice2 = input.nextInt();
                    input.nextLine();
                    switch (choice2) {
                        case 1:
                            System.out.println("Enter Product Name: ");
                            String ProductName = input.nextLine();
                            SearchProductByName(ProductName);
                            break;
                        case 2:
                            System.out.print("Enter Minimum Price for a product: ");
                            double MinPrice = input.nextDouble();
                            System.out.print("Enter Maximum Price for a product: ");
                            double MaxPrice = input.nextDouble();
                            PriceSearch(MinPrice, MaxPrice);
                            break;

                        case 3:
                            System.out.println("Enter Department Name: ");
                            String DepartmentnName = input.nextLine();
                            SearchProductByDepartment(DepartmentnName);
                            break;
                        case 4:
                            DisplayProducts();
                            System.out.println("Enter Product SKU You Want To Add: ");
                            String SKU = input.nextLine();
                            Product CartItem = SearchProductBySKU(SKU);
                            cart.add(CartItem);
                            DisplayCart();
                            break;
                        case 5:
                            running2 = false;
                            break;
                    }}
                    break;
                case 2:
                    DisplayCart();
                    boolean running3 = true;
                    while (running3) {
                    System.out.println("1- Check-Out ");
                    System.out.println("2- Remove Product ");
                    System.out.println("3- Exit to main Menu");
                    int choice3 = input.nextInt();
                    input.nextLine();
                    switch (choice3) {
                        case 1:
                            Checkout();
                            break;
                        case 2:
                            DisplayCart();
                            System.out.println("Enter Product SKU Want To Remove: ");
                            String SKU = input.nextLine();
                            RemoveProductFromCart(SKU);
                            DisplayCart();
                            break;
                        case 3:
                            running3 = false;
                            break;
                    }}
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    public static void DisplayProducts() {
        System.out.println("***  We Carry The Following  ** ");
        for (Product p : inventory) {
            System.out.println(p.toString());
        }
        System.out.println("_______________________________");
    }

    public static void DisplayCart() {
        double total = 0;
        System.out.println("***  Your Cart Carry The Following  ** ");
        for (Product p : cart) {
            total = total + p.getPrice();
            System.out.println(p.toString());
        }
        System.out.println("Your Total PriceFor This Cart Is $" + total);
        System.out.println("_______________________________");
    }

    public static void SearchProductByName(String ProductName) {
        boolean found = false;
        for(Product p : inventory) {
            if(p.getProductName().toLowerCase()
                    .contains(ProductName.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Product not found");
        }
    }

    public static Product SearchProductBySKU(String SKU) {
        for (Product p : inventory) {
            if (p.getSKU().equalsIgnoreCase(SKU)) {
                return p;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    public static void SearchProductByDepartment(String DepName) {
        boolean found = false;
        for(Product p : inventory) {
            if(p.getDepartment().equalsIgnoreCase(DepName)) {
                System.out.println(p);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Product not found");
        }
    }

    public static void PriceSearch(double min, double max) {
        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.println(p.toString());
            }
        }
    }

    public static void RemoveProductFromCart(String SKU) {
        for(int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getSKU().equalsIgnoreCase(SKU)) {
                cart.remove(i);
                break;
            }
        }
    }

    public static void Checkout() {
        double total = 0;
        for(Product p : cart)
        {
            total += p.getPrice();
        }

        System.out.printf("Total Due: $%.2f%n", total);
        double payment;
        do
        {
            System.out.print("Enter Payment Amount: ");
            payment = input.nextDouble();

            if(payment < total)
            {
                System.out.println("Insufficient payment.");
            }

        } while(payment < total);
        input.nextLine();
        double change = payment - total;
        PrintReceipt(total, payment, change);
        SaveReceipt(total, payment, change);
        cart.clear();
        System.out.printf("Change Due: $%.2f%n", change);
    }

    public static void PrintReceipt(double total, double payment, double change) {
        System.out.println("=================================");
        System.out.println("ONLINE STORE RECEIPT");
        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("=================================");

        for(Product p : cart)
            System.out.printf("%s | $%.2f%n", p.getProductName(), p.getPrice());

        System.out.println("---------------------------------");
        System.out.printf("Sales Total : $%.2f%n", total);
        System.out.printf("Amount Paid : $%.2f%n", payment);
        System.out.printf("Change Given: $%.2f%n", change);
    }

    public static void SaveReceipt(double total, double payment, double change) {
        try
        {
            String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));

            pw.println("=================================");
            pw.println("ONLINE STORE RECEIPT");
            pw.println("Date: " + LocalDateTime.now());
            pw.println("=================================");

            for(Product p : cart)
                pw.printf("%s | $%.2f%n", p.getProductName(), p.getPrice());

            pw.println("---------------------------------");
            pw.printf("Sales Total : $%.2f%n", total);
            pw.printf("Amount Paid : $%.2f%n", payment);
            pw.printf("Change Given: $%.2f%n", change);
            pw.close();
            System.out.println("Receipt saved to " + fileName);
        }
        catch(IOException e)
        {
            System.out.println("Error saving receipt.");
        }
    }

}