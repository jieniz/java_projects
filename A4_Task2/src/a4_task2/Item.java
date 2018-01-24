/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * all items provided in Jieni's Juice shop and store them a item.txt
 *
 * @author jieni
 */
public class Item {

    private final String[] description = {"Apple Juice", "Orange Juice", "Pineapple Juice", "Banana Juice", "Strawberry Juice", "Apricot Juice"};
    private final double[] price = {6.00, 6.50, 7.00, 7.00, 7.50, 8.00};

    private int shippingWeight;
    private int number;
    private int quantity;
    private String name;

    /**
     * no-arg constructor of Item class
     */
    public Item() {

    }

    /**
     * two arguments of item quantity and item name constructor of Item class
     *
     * @param itemQuantity the quantity for one item
     * @param itemName the name of the item
     */
    public Item(int itemQuantity, String itemName) {
        quantity = itemQuantity;
        name = itemName;
    }

    /**
     * get the price of one item multiplies quantity
     *
     * @return price for one item and multiple quantity
     */
    public double getPriceforQuantity() {

        for (int i = 0; i < 6; i++) {
            if (name.equals(description[i])) {//get the number of the item in description array
                number = i;
            }
        }
        return quantity * price[number];
    }

    /**
     * get the shipping weight for one item
     *
     * @param quantity the quantity for one item
     * @return shipping weight for one item
     */
    public int getWeight(int quantity) {
        shippingWeight = 500 * quantity;//assume that the shipping weight for one item one quantity is 500
        return shippingWeight;
    }

    /**
     * create item file to store item information
     */
    public void createItemFile() {
        File itemFile = new File("item.txt");//create new file
        try {
            PrintWriter output = new PrintWriter(itemFile);
            output.println("Items of Jieni's Juice Shop\n");//write strings in the file
            output.append(String.format("%-20s %8s\n", "Item", "Price"));//append strings to the file
            output.append(String.format("%-20s %8s\n", "----", "-----"));
            for (int i = 0; i < 6; i++) {
                output.append(String.format("%-20s %8.2f\n", description[i], price[i]));//append the information in description array and price array
            }
            output.close();//close the file output
        } catch (FileNotFoundException ex) {
        }
    }

    /**
     * add more items to the item file
     *
     * @param s the name of the added item
     * @param d the price of the added item
     */
    public void addItemtoFile(String s, double d) {
        File itemFile = new File("item.txt");
        try {
            PrintWriter output = new PrintWriter(itemFile);
            output.append(String.format("%-20s %8.2f\n", s, d));//add informtion in formatted strings
            output.close();//close the file
        } catch (FileNotFoundException ex) {//catch exception if the file is not found

        }
    }
}
