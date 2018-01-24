/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

import java.util.Scanner;

/**
 * collect the commands of the smart dog from the user.
 *
 * @author jieni
 */
public class Controller {

    private final int[] command = new int[100];
    private int length = 0;

    /**
     * ask the user to input commands one by one to instruct the smart dog to
     * walk around the playground with a marker.
     */
    public void readCommand() {

        while (true) {//iteration with a break
            System.out.print("Enter command ( 9 to end input ) : ");//ask the user to input the value of command
            Scanner scanner1 = new Scanner(System.in);
            int c = scanner1.nextInt();//scanner the input

            if (c == 1 || c == 2 || c == 3 || c == 4 || c == 5 || c == 6 || c == 9) {
                command[length] = c;//save commands into an array
                length++;
                
                if (c == 5) {//if command is 5, ask the user to input the forward spaces
                    System.out.print("Enter forward spaces : ");
                    Scanner scanner2 = new Scanner(System.in);
                    int n = scanner2.nextInt();
                    command[length] = n;//store the forward spaces into next parameter in the command array
                    length++;
                }
                if (c == 9) {//if command is 9, stop collecting commands from the user
                    break;
                }
            } else {//if the input is out of range, ask the user to input again or quit
                System.out.println("Your command is not correct. Please enter 0 to continue or enter any other numbers to quit.");
                Scanner scanner3 = new Scanner(System.in);
                int y = scanner3.nextInt();
                if (y != 0) {//if the input is not 0, break the iteration
                    break;
                }
            }         
        }
    }

    /**
     * get the command array that the user has inputed
     *
     * @return command array from an user
     */
    public int[] getCommandArray() {
        return command;
    }

    /**
     * get the number of commands that a user has inputed
     *
     * @return the number of commands/ the length of the command array
     */
    public int getLength() {
        return length;
    }

}
