package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalesContract extends Contract {
    private BigDecimal salesTax;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean finance=false;

    public SalesContract(String customerName,String customerEmail,Vehicle vehicleSold
            ,boolean finance)
    {
        super(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),customerName,customerEmail,vehicleSold);

        salesTax=getVehicleSold().getPrice().multiply(new BigDecimal("0.05"));

        recordingFee=BigDecimal.valueOf(100);

        BigDecimal vehiclePrice=getVehicleSold().getPrice();

        if (vehiclePrice.compareTo(BigDecimal.valueOf(10000))<0)
            processingFee=BigDecimal.valueOf(295);
        else
            processingFee=BigDecimal.valueOf(495);

        this.finance=finance;

    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }
    public BigDecimal getProcessingFee() {
        return processingFee;
    }
    public BigDecimal getRecordingFee() {
        return recordingFee;
    }
    public boolean isFinance() {
        return finance;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal vehiclePrice=getVehicleSold().getPrice();
        return ( (vehiclePrice.add(salesTax)).add(recordingFee).add(processingFee));
    }
    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal vehiclePrice=getVehicleSold().getPrice();

        if (finance){
            if(vehiclePrice.compareTo(BigDecimal.valueOf(10000))>=0)
                return getTotalPrice()
                        .multiply(new BigDecimal("1.0425"))
                        .divide(new BigDecimal("48"), 2, RoundingMode.HALF_UP);
            else
                return getTotalPrice()
                        .multiply(new BigDecimal("1.0525"))
                        .divide(new BigDecimal("24"), 2, RoundingMode.HALF_UP);
        }else {
            return new BigDecimal(0);
        }
    }
}
