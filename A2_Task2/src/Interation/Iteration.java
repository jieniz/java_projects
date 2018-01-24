/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interation;

import java.util.Scanner;

/**
 * Output the value of F(n) as the function is defined as F(0) = 3, F(1) = 5,
 * F(n) = F(n-1)+ 5* F(n-2) +n+3
 *
 * @author jieni
 */
public class Iteration {

    /**
     * get the value of n from the user
     *
     * @return n - the value of n in F(n)
     */
    public int getInput() {

        System.out.print("Please input the number of n (n>1): ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }

    /**
     * method F(n) uses iteration to implement the function
     *
     * @param n the parameter of F(n)
     * @return value - the value of F(n)
     */
    public int F(int n) {

        int value = 0;
        int value0 = 3;
        int value1 = 5;

        for (int loop = 2; loop <= n; loop++) {
            value = value1 + 5 * value0 + loop + 3;
            value0 = value1;
            value1 = value;
        }
        return value;
    }

}
