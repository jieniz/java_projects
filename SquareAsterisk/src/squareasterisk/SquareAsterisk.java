/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareasterisk;

import java.util.Scanner;

/**
 * Prompt the user to enter the size of the side of a square.Display a hollow
 * square of that size made of asterisks.Work for squares of all side lengths
 * between 1 and 20.
 *
 * @author jieni
 */
public class SquareAsterisk {

    /**
     *
     * main method is the only method in this project
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Please enter the size of a square between 1 and 20: ");
        Scanner scanner1 = new Scanner(System.in);
        int squareSide = scanner1.nextInt();

        if (squareSide == 1) {
            System.out.print("*");
        } else if ((squareSide <= 20) && (squareSide > 1)) {
            for (int number = 1; number <= squareSide; number++) {
                System.out.print("* ");
            }
            System.out.println("");
            for (int line = 1; line < (squareSide - 1); line++) {
                System.out.print("* ");
                for (int column = 1; column < (squareSide - 1); column++) {
                    System.out.print("  ");
                }
                System.out.println("*");
            }
            for (int row = 1; row < squareSide; row++) {
                System.out.print("* ");
            }
            System.out.println("*");
        } else {
            System.out.println("Your input is not avaliable!");
        }

    }

}
