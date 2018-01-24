/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeSpeed;

/**
 * check if the user typed the sentence correctly and print the number of
 * milliseconds the user took to type the sentence.
 *
 * @author jieni
 */
public class Task4 {

    /**
     * execute the program using TypeSpeed class and Time class
     *
     * @param args number of milliseconds the user took to type the sentence.
     */
    public static void main(String[] args) {

        TypeSpeed typeSpeed = new TypeSpeed();

        typeSpeed.outputTask();
        
        typeSpeed.timeStart();
        typeSpeed.timeEnd();

    }
}
