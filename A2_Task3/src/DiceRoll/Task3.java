/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoll;

/**
 * get input from the user and output a bar chart representing the percentage of
 * each value shows up
 *
 * @author jieni
 */
public class Task3 {

    /**
     * execute the program using Dice, Total and DiceRoll classes
     *
     * @param args a bar chart representing the percentage of each value shows
     * up
     */
    public static void main(String[] args) {

        DiceRoll diceRoll = new DiceRoll();
        diceRoll.setInput();
        diceRoll.setAccount();//get an array from Total class that represents the total number of each value showing up
        diceRoll.calculatePercentage();//get an array that represents the percentage of each value showing up
        diceRoll.generateBarChart();//generate a bar chart

    }
}
