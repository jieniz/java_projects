/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interation;

/**
 * execute Iteration class
 *
 * @author jieni
 */
public class Task2 {

    /**
     * ask the user to input the value of n and display the result of F(n) on
     * screen
     *
     * @param args display F(n)
     */
    public static void main(String[] args) {

        Iteration interation = new Iteration();

        System.out.println("F(n)=" + interation.F(interation.getInput()));
    }

}
