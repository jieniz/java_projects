/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task2;

/**
 * generate a story by using random-number generation
 *
 * @author jieni
 */
public class A6_Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomSentence rs = new RandomSentence();//create an object of RandomSentence

        System.out.println(rs.createParagraph());//output the story paragraph with 20 sentences.

    }

}
