package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle {
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    BigDecimal price;

    public Vehicle(int vin, int year, String make, String model,String vehicleType, String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

        public int getVin() {
            return vin;
        }

        public int getYear() {
            return year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public String getColor() {
            return color;
        }

        public int getOdometer() {
            return odometer;
        }

        public BigDecimal getPrice() {
            return price;
        }

}
