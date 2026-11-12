package com.pluralsight;

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
    public void addVehicle(Vehicle vehicle){}
    public void removeVehicle(Vehicle vehicle){}

}
