package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
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

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getPrice().compareTo(min)>=0  &&  vehicle.getPrice().compareTo(max)<=0){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make,String model){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getMake().equalsIgnoreCase(make)&&vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min,int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getYear()>=min&&vehicle.getYear()<=max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min,int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getOdometer()>=min&&vehicle.getOdometer()<=max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle:inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getAllVehicles(){
         return inventory;
    }

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
