package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dealership {
    String name;
    String address;
    String phone;
    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory=inventory;

    }

//    public ArrayList<Vehicle> getVehiclesByPrice(int min,int max){}
//    public ArrayList<Vehicle> getVehiclesByMakeModel(String make,String model){}
//    public ArrayList<Vehicle> getVehiclesByYea(int min,int max){}
//    public ArrayList<Vehicle> getVehiclesByColor(String color){}
//    public ArrayList<Vehicle> getVehiclesByMileage(int min,int max){}
//    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){}
//    public ArrayList<Vehicle> getAllVehicles(){}

    public Vehicle processGetByVin(int vin) {
        for (Vehicle v : inventory) {
            if (v.getVin() == vin) {
                return v;
            }
        }
        System.out.println("VIN: " + vin+" not found");
        return null;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
        Dealership dealership = new Dealership(name, address, phone, inventory);
        DealershipFileManger dealershipFileManger = new DealershipFileManger();
        dealershipFileManger.saveDealership(dealership);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
        Dealership dealership = new Dealership(name, address, phone, inventory);
        DealershipFileManger dealershipFileManger = new DealershipFileManger();
        dealershipFileManger.saveDealership(dealership);

    }

}
