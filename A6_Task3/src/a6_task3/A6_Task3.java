/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task3;

/**
 * creates two arrays containing random integers, generates two “List” objects
 * from these arrays and then produces another “List” after merging the values
 * in ascending order without duplicates.
 *
 * @author jieni
 */
public class A6_Task3 {

    /**
     * creates two arrays containing random integers, generates two “List”
     * objects from these arrays and then produces another “List” after merging
     * the values in ascending order without duplicates.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Generator generator = new Generator();//create an instance of Generator
        generator.mergeList(Generator.generateArray(), Generator.generateArray());//create lists and merge them
    }

}
