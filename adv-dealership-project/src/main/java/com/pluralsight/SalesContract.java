package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class SalesContract extends Contract {
    float salesTax=1.05f;
    double recordingFee=100;
    double processingFee=0;
    boolean finance=false;

    public SalesContract(String customerName,String customerEmail,Vehicle vehicleSold
            ,boolean finance)
    {
        super(LocalDateTime.now().toString(),customerName,customerEmail,vehicleSold);
        this.finance=finance;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal vehiclePrice=getVehicleSold().getPrice();
        if (vehiclePrice.compareTo(BigDecimal.valueOf(10000))<0)
            processingFee=295;
        else
            processingFee=495;

        return ( (vehiclePrice.multiply(new BigDecimal(salesTax)))
                    .add(new BigDecimal(recordingFee))
                    .add(new BigDecimal(processingFee))
        );
    }
    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal vehiclePrice=getVehicleSold().getPrice();

        if (finance){
            if(vehiclePrice.compareTo(BigDecimal.valueOf(10000))>=0)
                return (getTotalPrice().multiply(new BigDecimal(1.0425)).divide(new BigDecimal(48)));
            else
                return (getTotalPrice().multiply(new BigDecimal(1.0525)).divide(new BigDecimal(24)));
        }else {
            return new BigDecimal(0);
        }
    }
}
