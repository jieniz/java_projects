/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * register a customer with name and address and store the information into a
 * file
 *
 * @author jieni
 */
public class Customer {

    private String name;
    private String address;

    /**
     * ask the user to input the name and address of a customer and put them in
     * a file
     */
    public void registerCustomer() {
        System.out.print("Input name of customer: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();//save the input as the customer name
        System.out.print("Input address of customer: ");
        address = scanner.nextLine();//save the input as the customer address
        System.out.println("Registration completed.");

        File file = new File("customer.txt");//create a customer.txt file to store all the customer information
        try {
            FileWriter output = new FileWriter(file, true);//set true to write strings after original ones instead of replacing origanal strings 
            BufferedWriter fw = new BufferedWriter(output);//use BufferedWriter to avoid replacement
            fw.append(String.format("%-20s %-100s\n", name, address));//write formatted strings to the file
            fw.close();//close buffered writer
        } catch (IOException ex) {
        }
    }

    /**
     * get the name of the customer
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * get the address of the customer
     *
     * @return customer address
     */
    public String getAddress() {
        return address;
    }

    /**
     * create a customer file (at the beginning, do not have to do it every
     * time)
     */
    public void createCustomerFile() {
        File file = new File("customer.txt");//create customer.txt
        try {
            FileWriter output = new FileWriter(file);
            BufferedWriter fw = new BufferedWriter(output);
            fw.append("Registered Customer Information\n\n");
            fw.append(String.format("%-20s %-100s\n", "Name", "Address"));
            fw.append(String.format("%-20s %-100s\n", "----", "-------"));
            fw.close();
        } catch (IOException ex) {

        }

    }
}
