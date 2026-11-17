package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DealershipFileManger {


    static ArrayList<Vehicle> vehicles=new ArrayList<>();

    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String line;
            //D & B Used Cars|111 Old Benbrook Rd|817-555-5555
            line = reader.readLine();
            String[] title = line.split("\\|");
            String dealershipName=title[0];
            String dealershipAddress=title[1];
            String dealershipPhone=title[2];
            while((line = reader.readLine()) != null){

                String[] parts = line.split("\\|");
                //10112|1993|Ford|Explorer|SUV|Red|525123|995.00
                Vehicle vehicle = new Vehicle(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]), parts[2], parts[3], parts[4],parts[5],
                        Integer.parseInt(parts[6]),new BigDecimal(parts[7]));
                if(!vehicles.contains(vehicle)){
                    vehicles.add(vehicle);
                }
            }
            reader.close();
            return new Dealership(dealershipName,dealershipAddress
                    ,dealershipPhone,vehicles);
        }catch (IOException e){
            System.out.println("Empty DataFile");
            return null;
        }
    }

    public void saveDealership(Dealership dealership){
        try {
            FileWriter writer = new FileWriter("inventory.csv");
            writer.write(dealership.name+ "|" + dealership.address + "|" + dealership.phone + "\n");
            for(Vehicle vehicle:vehicles){
                writer.write(vehicle.vin + "|" + vehicle.year + "|" + vehicle.make
                        + "|" + vehicle.model + "|" + vehicle.vehicleType+ "|" +vehicle.color+
                        "|" +vehicle.odometer+ "|" +vehicle.price +"\n");
            }
            writer.close();
            Console.printGreen("Dealership Saved Successfully.");
        } catch (IOException e) {
            Console.printRed("Error Saving Dealership. ");
        }


    }

}
