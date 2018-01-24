/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.util.Formatter;
import java.util.Scanner;

/**
 * menu system for Jieni's Juice Shop on the console
 *
 * @author jieni
 */
public class Menu {

    private final String[] description = {"Apple Juice", "Orange Juice", "Pineapple Juice", "Banana Juice", "Strawburry Juice", "Apricot Juice"};
    private final double[] price = {6.00, 6.50, 7.00, 7.00, 7.50, 8.00};

    /**
     * print the menu of item information for customers to choose
     */
    public void printMenu() {
        Formatter formatter = new Formatter(System.out);
        System.out.println("Menu for Jieni's Juice");
        System.out.println("-----------------------------");
        for (int i = 0; i < 6; i++) {
            formatter.format("%-20s %8.2f\n", description[i], price[i]);
        }
    }

    /**
     * print the menu system on the console to take orders
     *
     * @return the order number that user inputs
     */
    public int order() {
        System.out.println("\nOrder System: ");
        System.out.println("1. Register new customer");
        System.out.println("2. Start new order");
        System.out.println("3. Display summary of purchase orders");
        System.out.println("4. Exit\n");
        System.out.print("Input number of process: ");//ask user to choose the number of one process
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();//take input as a String
        for (int i = 0; i <= 1;) {
            try {
                int q = Integer.parseInt(s);//check if the input is integer
                i++;
            } catch (NumberFormatException e) {//if not, ask user to input again
                System.out.println("Exception: The input is not integer. Please try again...");
                System.out.print("Input number of process: ");
                s = scanner.nextLine();
            }
        }
        int q = Integer.parseInt(s);
        while (q != 1 && q != 2 && q != 3 && q != 4) {//check if the input is 1 or 2 or 3 or 4
            System.out.println("Your input is not valid. Please try again...");
            System.out.print("Input number of process: ");
            s = scanner.nextLine();
            for (int i = 0; i <= 1;) {
                try {
                    q = Integer.parseInt(s);
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Exception: The input is not integer. Please try again...");
                    System.out.print("Input number of process: ");
                    s = scanner.nextLine();
                }
            }
            q = Integer.parseInt(s);
        }
        return q;

    }

}
