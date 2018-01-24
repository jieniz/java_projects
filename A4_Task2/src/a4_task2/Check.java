/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

import java.util.Scanner;

/**
 * a subclass of Payment when people pay by check, input the name and bank ID
 * and confirm with authorization
 *
 * @author jieni
 */
public class Check extends Payment implements Authorization {

    private String name;
    private long bankID;

    /**
     * constructor that take input as the amount of required pay
     *
     * @param a
     */
    public Check(double a) {
        super(a);
    }

    /**
     * get the name and bank ID from the user
     */
    public void setCheck() {
        System.out.print("Input name of check: ");//ask user to input the name of check
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        name = s;//take input as the name of check
        System.out.print("Input bank ID of check: ");//ask user to input bank ID
        s = scanner.nextLine();
        for (int i = 0; i <= 1;) {//check if input is integer which supposed to be enough for a bank ID
            try {
                int d = Integer.parseInt(s);//convert the String to integer
                i++;
            } catch (NumberFormatException e) {//in failed, ask the user to input again
                System.out.println("Exception: The bank ID is not valid. Please try again...");
                System.out.print("Input bank ID of check:  ");
                s = scanner.nextLine();
            }
        }
        bankID = Integer.parseInt(s);//pass the input to the value of bankID
    }

    @Override
    public void confirm() {
        System.out.println("Approved.");
    }

}
