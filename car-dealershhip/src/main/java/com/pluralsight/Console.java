package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Console {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLACK = "\u001B[30m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    private static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    public static BigDecimal promptForBigDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                BigDecimal value = new BigDecimal(scanner.nextLine().trim());
                return value.setScale(2, RoundingMode.HALF_UP);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }

    public static double promptForDouble(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static int promptForInt(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static char promptForChar(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.length() == 1) {
                return Character.toUpperCase(input.charAt(0));
            }

            System.out.println("Please enter a single character.");
        }
    }

    public static void printGreen(String message) {
        System.out.println(GREEN + message + RESET);
    }

    public static void printRed(String message) {
        System.out.println(RED + message + RESET);
    }
}