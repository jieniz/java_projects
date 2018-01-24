/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.util.Scanner;

/**
 * a subclass of Payment when people pay by credit and check with the
 * authorization
 *
 * @author jieni
 */
public class Credit extends Payment implements Authorization {

    private final String[] creditType = {"VISA", "MasterCard"};
    private String type;
    private long number;
    private int expDate;

    /**
     * constructor that take the input as required amount
     *
     * @param a
     */
    public Credit(double a) {
        super(a);
    }

    /**
     * ask the user and get input as credit type, credit number and expire date
     * and check them separately whether the input is valid
     */
    public void setCredit() {

        System.out.print("Input credit type (VISA/MasterCard): ");//ask user to input credit type
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!checkType(s)) {//if the type of the credit is not matched, ask the user to input again
            System.out.println("The type of the credit is wrong. Please try again.");
            System.out.print("Input credit type:  ");
            s = scanner.nextLine();//scan next line
        }
        type = s;//pass input to type 

        System.out.print("Input credit number: ");//ask user to input credit number
        s = scanner.nextLine();
        for (int i = 0; i <= 1;) {//check if input is number
            try {
                long q = Long.parseLong(s);//convert String to long type
                i++;
            } catch (NumberFormatException e) {//if conversion failed, ask user to input again
                System.out.println("Exception: The number is not valid. Please try again...");
                System.out.print("Input credit number:  ");
                s = scanner.nextLine();
            }
        }
        number = Long.parseLong(s);//pass the long value to credit number

        System.out.print("Input credit expire date: ");//ask user to input expire date--4 digit
        s = scanner.nextLine();
        for (int i = 0; i <= 1;) {//check if input is integer
            try {
                int date = Integer.parseInt(s);//convert String to int type
                i++;
            } catch (NumberFormatException e) {//if conversion failed, ask user to try again
                System.out.println("Exception: The expire date is not valid. Please try again...");
                System.out.print("Input credit expire date:  ");
                s = scanner.nextLine();
            }
        }
        expDate = Integer.parseInt(s);

    }

    /**
     * check whether the input is matched to the valid credit type -- VISA or
     * MasterCard
     *
     * @param s take input as the credit type
     * @return if input is matched to valid credit type, return true; otherwise,
     * return false
     */
    public boolean checkType(String s) {
        boolean check = false;
        int j = 0;
        for (int i = 0; i < 2; i++) {
            if (s.equals(creditType[i])) {//if input is the same as any string in creditType array, return true
                j++;
            }
        }
        if (j == 1) {
            check = true;
        }
        return check;
    }

    @Override
    public void confirm() {
        System.out.println("Approved.");
    }
}
