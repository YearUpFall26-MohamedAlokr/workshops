package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManger {
    public void saveContract(Contract contract){
        //SALE|20210928|Fred Wyatt|fred@texas.com
        // |10112|1993|Ford|Explorer|SUV|Red|525123|995.00
        // |49.75|100.00|295.00|1439.75|NO|0.00
            try {
                FileWriter writer = new FileWriter("contracts.csv",true);
                Vehicle vehicle= contract.getVehicleSold();
                if (contract instanceof SalesContract ) {
                    SalesContract salesContract = (SalesContract) contract;
                    writer.write("SALE" + "|" + contract.getDate() + "|" + contract.getCustomerName()
                            + "|" + contract.getCustomerEmail() + "|" + vehicle.vin + "|" + vehicle.year + "|"
                            + "|" + vehicle.make + "|" + vehicle.model + "|" + vehicle.vehicleType
                            + "|" + vehicle.color + "|" + vehicle.odometer + "|" + vehicle.price
                            + "|" + salesContract.salesTax+ "|" + salesContract.recordingFee
                            + "|" + "|" + salesContract.processingFee + "|" + salesContract.getTotalPrice()
                            + "|" + "|" + (salesContract.finance ? "YES" : "NO")+ "|"
                            + salesContract.getMonthlyPayment()+ "\n");
                }else if (contract instanceof LeaseContract ){
                    //LEASE|20210928|Charles Westly|Charles@texas.com|
                    // 37846|2021|Chevrolet|Silverado|truck|Black|2750|31995.00|
                    // 15997.50|2239.65|18237.15|538.43
                    LeaseContract leaseContract = (LeaseContract) contract;
                    writer.write("LEASE" + "|" + contract.getDate() + "|" + contract.getCustomerName()
                            + "|" + contract.getCustomerEmail() + "|" + vehicle.vin + "|" + vehicle.year + "|"
                            + "|" + vehicle.make + "|" + vehicle.model + "|" + vehicle.vehicleType
                            + "|" + vehicle.color + "|" + vehicle.odometer + "|" + vehicle.price
                            + "|" + leaseContract.getExpectedEndingValue()+ "|" + leaseContract.getLeaseFee()
                            + "|" + "|" + leaseContract.getTotalPrice()+ "|" + leaseContract.getMonthlyPayment()+ "\n");
                }
            writer.close();
            Console.printGreen("Contract Saved Successfully.");
        } catch (IOException e) {
            Console.printRed("Error Saving Contract. ");
        }

    }
}
