package com.pluralsight;


import java.math.BigDecimal;
import java.util.ArrayList;

public class UserInterface {
    static Dealership dealership;

    private void init(){
        DealershipFileManger dealership=new DealershipFileManger();
        this.dealership=dealership.getDealership();
    }

    public void display(){
        init();
        boolean running = true;
        while(running) {
            System.out.println("__________________________________");
            System.out.println("** Welcome to Car DelarShip Menu **");
            System.out.println("1- To Get All Vehicles");
            System.out.println("2- To Add Vehicle");
            System.out.println("3- To Remove Vehicle");
            System.out.println("4- To Search By Price");
            System.out.println("5- To Search By Make & Model");
            System.out.println("6- To Search By Year");
            System.out.println("7- To Search By Color");
            System.out.println("8- To Search By Mileage");
            System.out.println("9- To Search By Vehicle Type");
            System.out.println("0- To Exit");

            int option= Console.promptForInt("Enter Your Choice: ");
            switch (option) {
                case 0:
                    running = false;
                    break;
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processAddVehicleRequest();
                    break;
                case 3:
                    processRemoveVehicleRequest();
                    break;
                case 4:
                    processGetByPriceRequest();
                    break;
                case 5:
                    processGetByMakeModelRequest();
                    break;
                case 6:
                    processGetByYearRequest();
                    break;
                case 7:
                    processGetByColorRequest();
                    break;
                case 8:
                    processGetByMileageRequest();
                    break;
                case 9:
                    processGetByVehicleTypeRequest();
                    break;
                default:
                    System.out.println("Invalid Choice Please Try Again");
            }

        }
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("------------------------------------------------------------------------------------");

        // Print each vehicle row
        for (Vehicle v : vehicles) {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                    v.getVin(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getVehicleType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice());
        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.inventory);
    }

    public void processAddVehicleRequest() {
    int vin=Console.promptForInt("Enter VIN: ");
    if (dealership.processGetByVin(vin) != null) {
        System.out.println("Error: A vehicle with VIN " + vin + " already exists in inventory.");
        return;
    }
    int year=Console.promptForInt("Enter Year: ");
    String make=Console.promptForString("Enter Make: ");
    String model=Console.promptForString("Enter Model: ");
    String type=Console.promptForString("Enter Type: ");
    String color=Console.promptForString("Enter Color: ");
    int mileage=Console.promptForInt("Enter Mileage: ");
    BigDecimal price=Console.promptForBigDecimal("Enter Price: ");
    Vehicle vehicle=new Vehicle(vin, year, make, model, type, color, mileage, price);
    dealership.addVehicle(vehicle);
    }

    public void processRemoveVehicleRequest() {
    int vin =Console.promptForInt("Enter VIN: ");
    dealership.removeVehicle( dealership.processGetByVin(vin) );
    }

    public void processGetByPriceRequest() {
        displayVehicles(
                dealership.getVehiclesByPrice(
                        Console.promptForBigDecimal("Enter Min Price: "),
                        Console.promptForBigDecimal("Enter Max Price: ")
                )
        );
    }

    public void processGetByMakeModelRequest() {
        displayVehicles(
                dealership.getVehiclesByMakeModel(
                        Console.promptForString("Enter Make : ")
                        ,Console.promptForString("Enter Model : ")
                )
        );
    }

    public void processGetByYearRequest() {
        displayVehicles(
                dealership.getVehiclesByYear(
                        Console.promptForInt("Enter Start Year : ")
                        ,Console.promptForInt("Enter End Year : ")
                )
        );
    }

    public void processGetByColorRequest() {
        displayVehicles(
                dealership.getVehiclesByColor(
                        Console.promptForString("Enter Color : ")
                )
        );
    }

    public void processGetByMileageRequest() {
        displayVehicles(
                dealership.getVehiclesByMileage(
                        Console.promptForInt("Enter Min Mileage "),
                        Console.promptForInt("Enter Max Mileage : ")
                )
        );
    }

    public void processGetByVehicleTypeRequest() {
        displayVehicles(
                dealership.getVehiclesByType(
                        Console.promptForString("Enter Type : ")
                )
        );
    }

}

