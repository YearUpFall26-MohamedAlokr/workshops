package org.example;

import java.util.Scanner;

public class financialCalulators {
    public static void main() {

        //Calling user interface method
        ui();
    }

    public static void ui(){
        Scanner input = new Scanner(System.in);

        // User's Menu
        System.out.println("Enter 1 For Mortgage Calculator");
        System.out.println("Enter 2 For Future value Calculator");
        System.out.println("Enter 3 For Annuity Present value Calculator");
        int Calculator=input.nextInt();

        //Filling Input
        System.out.println("Enter Principle Value Without $ sign");
        double principal = input.nextDouble();
        System.out.println("Enter Interest Rate Without % sign");
        double interest_rate = input.nextDouble();
        System.out.println("Enter Number Of Years");
        double years = input.nextDouble();

        //Choosing Which Calculator
        if(Calculator==1){
            mortgage_calculator(principal,interest_rate,years);
        } else if (Calculator==2) {
            future_value_calculator(principal,interest_rate,years);
        } else if (Calculator==3) {
            annuity_calculator(principal,interest_rate,years);
        }else {
            System.out.println("Invalid input");
        }

    }

    public static void mortgage_calculator(double principal, double interest_per, double years) {
        double int_rat=interest_per/100;
        double monthly_interest_rate=int_rat/12;
        double num_month=years*12;
        double mortgage = principal * (monthly_interest_rate * Math.pow(1 + monthly_interest_rate, num_month)) / (Math.pow(1 + monthly_interest_rate, num_month) - 1);
        double totalIntrest = mortgage*num_month;
        System.out.println("Monthly Payment = "+mortgage+"$");
        System.out.println("Total Intrest = "+totalIntrest+"$");
    }

    public static void future_value_calculator(double principal, double interest_per, double years) {
        double ann_int_rat= interest_per /100;
        double days=365;
        double total_days=days* years;
        double future_value = principal * ( Math.pow((1+(ann_int_rat/days)), total_days)) ;
        double total_intrest = future_value- principal;
        System.out.println("Future Value = "+future_value+"$");
        System.out.println("Total Interest Earned = "+total_intrest+"$");
    }

    public static void annuity_calculator(double Principal, double interest_per, double years) {
        double int_rat=interest_per/100;
        double monthly_interest_rate=int_rat/12;
        double num_month=years*12;
        double value = Principal * ((1 - Math.pow(1 + monthly_interest_rate, -num_month)) / monthly_interest_rate);
        System.out.println("Annuity Present Value = "+value+"$");
    }

}


