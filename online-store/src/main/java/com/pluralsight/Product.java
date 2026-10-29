package com.pluralsight;

public class Product {
    private String SKU;
    private String ProductName;
    private double Price;
    private String Department;
    public Product(String SKU, String ProductName, double Price, String Department) {
        this.SKU = SKU;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Department = Department;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }
    public void setProductName(String ProductNAME) {
        this.ProductName = ProductNAME;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setPrice(double price) {
        this.Price = price;
    }
    public double getPrice() {
        return Price;
    }
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public String getDepartment() {
        return Department;
    }

    @Override
    public String toString() {
        return SKU + "|" + ProductName + "|" + Price+ "|" + Department;
    }
}
