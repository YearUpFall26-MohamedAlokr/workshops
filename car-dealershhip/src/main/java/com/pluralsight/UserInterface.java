package com.pluralsight;


import java.util.ArrayList;

public class UserInterface {
    Dealership dealership;

    private void init(){
        DealershipFileManger dealership=new DealershipFileManger();
        this.dealership=dealership.getDealership();
    }

    public void display(){
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

            System.out.println("4- To Search By Mileage");

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
        for (Vehicle v : vehicles){
            System.out.println("VIN: "+v.vin +"Year: "+v.year
                    +"Make: "+v.make +"Model: "+v.model
                    +"Type "+v.vehicleType +"Color: "+v.color
                    +"Odometer: "+v.odometer +"Price: "+v.price
            );
        }
    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {
        ArrayList<Vehicle> vehicles=dealership.inventory;
        displayVehicles(vehicles);
    }

    public void processRemoveVehicleRequest() {

    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

}

