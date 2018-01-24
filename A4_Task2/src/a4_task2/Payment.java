/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.util.Formatter;
import java.util.Scanner;

/**
 * ask user and take input as payment information, get authorization and return
 * payment information
 *
 * @author jieni
 */
public class Payment {

    private final String[] paymentType = {"Credit", "Cash", "Check"};
    private String type;
    private final double amount;
    private double cashPayed;

    /**
     * constructor with one argument
     *
     * @param pay the total amount of the payment
     */
    public Payment(double pay) {
        amount = pay;
    }

    /**
     * ask user and take input as the payment type
     */
    public void setType() {
        System.out.print("Input payment method (Credit/Cash/Check): ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!checkPaymentType(s)) {//check if the input is credit or cash or check, if not, ask user to input again
            System.out.println("The type of the payment is wrong. Please try again.");
            System.out.print("Input payment method (Credit/Cash/Check):  ");
            s = scanner.nextLine();
        }
        type = s;
    }

    /**
     * get the type of the payment
     *
     * @return payment type
     */
    public String getType() {
        return type;
    }

    /**
     * check if the payment type is valid
     *
     * @param s the input of payment type from user
     * @return true if valid, otherwise false
     */
    public boolean checkPaymentType(String s) {
        boolean check = false;
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (s.equals(paymentType[i])) {
                j++;
            }
        }
        if (j == 1) {
            check = true;
        }
        return check;
    }

    /**
     * pay amount using different types
     *
     * @return cash tendered from customer
     */
    public double payAmount() {
        if (type.equals(paymentType[0])) {//if it is credit
            Credit credit = new Credit(amount);
            credit.setCredit();
            credit.confirm();
            //connect to Authorization
        } else if (type.equals(paymentType[1])) {//if it is cash
            Cash cash = new Cash(amount);
            cash.getCash();
            Formatter formatter = new Formatter(System.out);
            System.out.print("Change(cash): ");
            formatter.format("%4.2f\n", cash.getChange());
            cashPayed = cash.getCashTendered();
        } else if (type.equals(paymentType[2])) {//if it is check
            Check check = new Check(amount);
            check.setCheck();
            check.confirm();
        }
        return cashPayed;
    }

    /**
     * get the total amount of the order
     *
     * @return
     */
    public double getAmount() {
        return amount;
    }

    /**
     * get the cash tendered from the customer
     *
     * @return
     */
    public double getCashTendered() {
        return cashPayed;
    }
}
