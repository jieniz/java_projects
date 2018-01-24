/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoll;

import java.util.Scanner;
import java.util.Formatter;

/**
 * ask the user for n(the number of rolls), simulate the rolling of the two dice
 * for n times, add to compute the total and draw a bar chart showing the
 * respective frequency of each total as results.
 *
 * @author jieni
 */
public class DiceRoll {

    /**
     * field of n - the times of rolling from the user
     */
    public int n;
    /**
     * field of array account
     */
    public int[] account = new int[11];

    /**
     * get the times of rolling from the user
     *
     */
    public void setInput() {
        System.out.print("Please input the number of n : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        n = number;
    }

    /**
     * get the value of field number
     *
     * @return number - the number of dice rolling
     */
    public int getInput() {
        int number = n;
        return number;
    }

    /**
     *
     */
    public void setAccount() {
        int[] total = new int[n];

        for (int loop = 0; loop < n; loop++) {

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            total[loop] = dice1.rollDice() + dice2.rollDice();

            for (int i = 0; i <= 10; i++) {
                if (total[loop] == (i + 2)) {
                    account[i]++;
                }
            }
        }
    }

    /**
     * calculate the percentage of each value shows up
     *
     */
    public void calculatePercentage() {

        double[] percentage = new double[11];
        for (int j = 0; j <= 10; j++) {
            percentage[j] = 100.00 * account[j] / n;
            account[j] = (int) Math.round(percentage[j]);//improve the accuracy of ]results

        }
    }

    /**
     * generate a bar chart that represents the percentage of each value showing
     * up from 2 to 12
     *
     */
    public void generateBarChart() {

        for (int j = 0; j <= 10; j++) {

            Formatter formatter = new Formatter(System.out);
            formatter.format("%-5d", j + 2);//format the outputs

            for (; account[j] > 0; account[j]--) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

}
