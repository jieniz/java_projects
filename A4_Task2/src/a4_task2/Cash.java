/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.util.Scanner;

/**
 * a subclass of Payment when people pay by cash, input the cash tendered and
 * return the value of change and show the information in the receipt and order
 * file
 *
 * @author jieni
 */
public class Cash extends Payment {

    private double cashTendered;

    /**
     * constructor that takes the required amount for the order as input and
     * pass the value as amount
     *
     * @param a required amount of the total price
     */
    public Cash(double a) {
        super(a);
    }

    /**
     * ask the user to input the amount of cash tendered and check the input
     */
    public void getCash() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the cash tendered: ");
        String s = scanner.nextLine();//get the input line
        for (int i = 0; i <= 1;) {
            try {
                double cash = Double.parseDouble(s);//try to convert the input to double value
                i++;
            } catch (NumberFormatException e) {//if the conversion is failed, ask the user to input again
                System.out.println("Exception: The cash tendered is not valid. Please try again...");
                System.out.print("Input the cash tendered:  ");
                s = scanner.nextLine();
            }
        }
        cashTendered = Double.parseDouble(s);
        while (cashTendered < super.getAmount()) {//if the amount of cash tendered is less than the required amount, ask the user to input again
            System.out.println("The cash tendered is less than required amount. Please try again...");
            System.out.print("Input the cash tendered: ");
            s = scanner.nextLine();
            for (int i = 0; i <= 1;) {
                try {
                    double cash = Double.parseDouble(s);//try to convert the input to double value
                    i++;
                } catch (NumberFormatException e) {//if failed, ask to input again
                    System.out.println("Exception: The cash tendered is not valid. Please try again...");
                    System.out.print("Input the cash tendered:  ");
                    s = scanner.nextLine();
                }
            }
            cashTendered = Double.parseDouble(s);
        }

    }

    /**
     * get the value of cash tendered
     *
     * @return amount of cash tendered
     */
    public double getCashTendered() {
        return cashTendered;
    }

    /**
     * get the value of change for the customer
     *
     * @return amount of change
     */
    public double getChange() {
        return cashTendered - super.getAmount();
    }
}
