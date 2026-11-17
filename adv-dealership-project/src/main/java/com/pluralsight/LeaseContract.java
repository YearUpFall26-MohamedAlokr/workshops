package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class LeaseContract extends Contract {
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;
    public LeaseContract(String customerName,String customerEmail,Vehicle vehicleSold,
                         double expectedEndingValue, double leaseFee) {
        super(LocalDate.now().toString(),customerName,customerEmail,vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice().multiply(new BigDecimal(.5));
        this.leaseFee = vehicleSold.getPrice().multiply(new BigDecimal(.07));
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return expectedEndingValue.add(leaseFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal principal = getTotalPrice();

        double annualRate = 0.04;
        int months = 36;

        double monthlyRate = annualRate / 12;

        double payment =
                principal.doubleValue() *
                        (monthlyRate /
                                (1 - Math.pow(1 + monthlyRate, -months)));

        return BigDecimal.valueOf(payment)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
