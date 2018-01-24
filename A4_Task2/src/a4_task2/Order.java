/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Formatter;

/**
 * take order and payment information from the user, print receipt on the
 * console and store order details in a file
 *
 * @author jieni
 */
public class Order {

    private String date;
    private String[] status = {"processing", "dispatched", "delayed"};//0: not start yet, 1: processing, 2: delivering, 3: complete
    private double tax;
    private double total;
    private int totalWeight;
    String[] itemName;
    int[] itemQuantity;

    /**
     * create a order file to store every order details
     */
    public void createOrderFile() {
        File orderFile = new File("order.txt");
        try {
            PrintWriter output = new PrintWriter(orderFile);
            output.println("Order Details of Jieni's Juice Shop\n");
            output.close();
        } catch (FileNotFoundException ex) {

        }

    }

    /**
     * ask user and take input as order and payment information
     */
    public void setOrder() {

        ArrayList allItemName = new ArrayList();
        ArrayList allItemQuantity = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String s;

        do {
            System.out.print("Input name of the item (i.e. Apple Juice):  ");//ask user to input name of the item

            s = scanner.nextLine();
            while (!checkItemName(s)) {//check if it is a valid name
                System.out.println("The name of the item is wrong. Please try again.");
                System.out.print("Input name of the item (i.e. Apple Juice):  ");
                s = scanner.nextLine();
            }
            allItemName.add(s);//add input to allItemName arraylist

            System.out.print("Input quantity of the item:  ");//ask user to input quantity of the item
            s = scanner.nextLine();

            for (int i = 0; i <= 1;) {
                try {
                    int q = Integer.parseInt(s);//convert String to integer
                    i++;

                } catch (NumberFormatException e) {//if conversion failed, ask the user to input again
                    System.out.println("Exception: The quantity is not integer. Please try again...");
                    System.out.print("Input quantity of the item (i.e. Apple Juice):  ");
                    s = scanner.nextLine();
                }
            }
            int q = Integer.parseInt(s);
            allItemQuantity.add(q);//add input to allItemQuantity arraylist

            System.out.println("Do you want to add another item? Please enter 'yes' or 'no'.");//ask user if want to add another item
            s = scanner.nextLine();
            while (!"yes".equals(s) && !"no".equals(s)) {//if the answer is not yes or no, ask user to input again
                System.out.println("Your input was invalid. Please try again...");
                System.out.println("Do you want to add another item? Please enter 'yes' or 'no'.");
                s = scanner.nextLine();
            }
        } while ("yes".equals(s));//if answer is yes, repeat the process

        String[] n = new String[allItemName.size()];//convert arraylist to array
        for (int i = 0; i < allItemName.size(); i++) {
            n[i] = (String) allItemName.get(i);
        }
        itemName = n;//pass the value from allItemName arraylist to itemName array

        int[] m = new int[allItemQuantity.size()];
        for (int i = 0; i < allItemQuantity.size(); i++) {
            m[i] = (int) allItemQuantity.get(i);
        }
        itemQuantity = m;//pass the value from allItemQuantity arraylist to itemQuantity array

    }

    /**
     * check if the input is matched to the valid item names
     *
     * @param name the item name that user inputs
     * @return true if input is matched to valid item names; otherwise, return
     * false
     */
    public boolean checkItemName(String name) {
        boolean check = false;
        String[] item = {"Apple Juice", "Orange Juice", "Pineapple Juice", "Banana Juice", "Strawberry Juice", "Apricot Juice"};
        int j = 0;
        for (int i = 0; i < 6; i++) {
            if (name.equals(item[i])) {
                j++;
            }
        }
        if (j == 1) {
            check = true;
        }
        return check;
    }

    /**
     * check if the input of item quantity if more than zero
     *
     * @param quantity the input of item quantity from user
     * @return true if the input is more than zero; otherwise, return false
     */
    public boolean checkQuantity(int quantity) {
        boolean check = false;
        if (quantity > 0) {
            check = true;
        }
        return check;
    }

    /**
     * set the date right now
     */
    public void setDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//format the date
        date = df.format(new Date());//obtain the date and time right now
    }

    /**
     * get the date
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * calculate tax of all items by adding tax of each one item
     */
    public void calcTax() {
        for (int i = 0; i < itemQuantity.length; i++) {
            OrderDetail orderDetail = new OrderDetail(itemQuantity[i], itemName[i]);
            tax = tax + orderDetail.calSubTax();
        }
    }

    /**
     * get the tax
     *
     * @return total tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * calculate the total amount of the order
     */
    public void calcTotal() {
        for (int i = 0; i < itemQuantity.length; i++) {
            OrderDetail orderDetail = new OrderDetail(itemQuantity[i], itemName[i]);
            total = total + orderDetail.calcSubTotal();
        }
        total = total + tax;
    }

    /**
     * get the total amount of the order
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * calculate the total weight of the order
     */
    public void calcTotalWeight() {
        for (int i = 0; i < itemQuantity.length; i++) {
            OrderDetail orderDetail = new OrderDetail(itemQuantity[i], itemName[i]);
            totalWeight = totalWeight + orderDetail.calcWeight();
        }
    }

    /**
     * get the total weight of the order
     *
     * @return
     */
    public int getWeight() {
        return totalWeight;
    }

    /**
     * print the receipt based on the order and payment information
     *
     * @param type the type of the credit card
     * @param cashTendered the cash tendered from the customer
     */
    public void printReceipt(String type, double cashTendered) {
        System.out.println("\n\nJieni's Juice Shop\n");

        Formatter formatter = new Formatter(System.out);//print the item, quantity and subtotal for one item
        formatter.format("%-17s %3s %7s\n", "Item", "Qty", "Price");
        formatter.format("%-17s %3s %7s\n", "----", "---", "-----");

        for (int i = 0; i < itemQuantity.length; i++) {
            OrderDetail orderDetail = new OrderDetail(itemQuantity[i], itemName[i]);
            formatter.format("%-17s %3d %7.2f\n", itemName[i], itemQuantity[i], orderDetail.calcSubTotal());
        }
        formatter.format("%-17s %3s %7.2f\n", "Tax", "", tax);//print the tax
        formatter.format("%-17s %3s %7s\n", "", "", "-----");
        formatter.format("%-17s %3s %7.2f\n", "Total", "", total);//print the total amount
        formatter.format("%-27s\n\n", date);//print the date
        if (type.equals("Credit")) {//if payment is credit, print the payment type
            formatter.format("%-17s %11s\n", "Payment Type", type);
        } else if (type.equals("Cash")) {//if payment is cash, print the cash tendered and required change
            formatter.format("%-17s %11s\n", "Payment Type", type);
            formatter.format("%-20s %8.2f\n", "Cash ", cashTendered);
            formatter.format("%-20s %8.2f\n", "Change ", cashTendered - total);
        } else if (type.equals("Check")) {//if the payment is check, print the payment type
            formatter.format("%-17s %11s\n", "Payment Type", type);
        }
        formatter.format("%-17s %11s\n", "Balance", "0.00");//print the final balance, which is zero
    }

    /**
     * write order details to the order.txt file
     */
    public void writeOrder() {
        File orderFile = new File("order.txt");
        try {
            FileWriter fw = new FileWriter(orderFile, true);
            BufferedWriter output = new BufferedWriter(fw);

            output.append(String.format("%-17s %3s %7s\n", "Item", "Qty", "Price"));//write the item, quantity and subtotal
            output.append(String.format("%-17s %3s %7s\n", "----", "---", "-----"));
            for (int i = 0; i < itemQuantity.length; i++) {
                OrderDetail orderDetail = new OrderDetail(itemQuantity[i], itemName[i]);
                output.append(String.format("%-17s %3d %7.2f\n", itemName[i], itemQuantity[i], orderDetail.calcSubTotal()));
            }
            output.append(String.format("%-17s %3s %7s\n", "", "", "-----"));
            output.append(String.format("%-17s %3s %7.2f\n", "Total", "", total));//write the total amount of the order
            output.append(String.format("%-27s\n\n", date));//write the date of the order
            output.close();

        } catch (IOException ex) {

        }
    }

    /**
     * print content from the order.txt on the console
     */
    public void printOrderFile() {
        try {
            Scanner sc = new Scanner(new File("order.txt"));
            while (sc.hasNextLine()) {//while order.txt has next line, print it out
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {

        }
    }

}
