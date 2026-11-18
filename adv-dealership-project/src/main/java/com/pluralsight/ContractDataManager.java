package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract){
            try {
                FileWriter writer = new FileWriter("contracts.csv",true);
                Vehicle vehicle= contract.getVehicleSold();
                if (contract instanceof SalesContract ) {
                    SalesContract salesContract = (SalesContract) contract;
                    writer.write("SALE" + "|" + contract.getDate() + "|" + contract.getCustomerName()
                            + "|" + contract.getCustomerEmail() + "|" + + vehicle.getVin() + "|" + vehicle.getYear()
                            + "|" + vehicle.getMake() + "|" + vehicle.getModel()+ "|" + vehicle.getVehicleType()
                            + "|" + vehicle.getColor()+ "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
                            + "|" + salesContract.getSalesTax()+ "|" + salesContract.getRecordingFee()
                            + "|" + salesContract.getProcessingFee() + "|" + salesContract.getTotalPrice()
                            + "|" + (salesContract.isFinance() ? "YES" : "NO")+ "|"
                            + salesContract.getMonthlyPayment()+ "\n");
                }else if (contract instanceof LeaseContract ){
                    LeaseContract leaseContract = (LeaseContract) contract;
                    writer.write("LEASE" + "|" + contract.getDate() + "|" + contract.getCustomerName()
                            + "|" + contract.getCustomerEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear()
                            + "|" + vehicle.getMake() + "|" + vehicle.getModel()+ "|" + vehicle.getVehicleType()
                            + "|" + vehicle.getColor()+ "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
                            + "|" + leaseContract.getExpectedEndingValue()+ "|" + leaseContract.getLeaseFee()
                            + "|" + leaseContract.getTotalPrice()+ "|" + leaseContract.getMonthlyPayment()+ "\n");
                }
            writer.close();
            Console.printGreen("Contract Saved Successfully.");
        } catch (IOException e) {
            Console.printRed("Error Saving Contract. ");
        }

    }
}
