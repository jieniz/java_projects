/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task1;

/**
 * read from a text file and output 15 words appears most in the text file
 *
 * @author jieni
 */
public class A6_Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Excuse excuse = new Excuse();
        excuse.readFile("homeworkExcuses.txt");
        excuse.appear();
        excuse.display();
    }

}
