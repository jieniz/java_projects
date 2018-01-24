/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * creates two arrays containing random integers, generates two “List” objects
 * from these arrays and then produces another “List” after merging the values
 * in ascending order without duplicates.
 *
 * @author jieni
 */
public class Generator {

    /**
     * create two arrays with random numbers and merge them in ascending order
     * without duplicates
     *
     * @param array1 the first array list containing random integers
     * @param array2 the second array list containing random integers
     */
    public void mergeList(ArrayList<Integer> array1, ArrayList<Integer> array2) {

        //output original array list
        System.out.println("First Array Contains: \n" + array1 + "\n");
        System.out.println("Second Array Contains: \n" + array2 + "\n");

        //remove duplicates and sort in ascending order for each array list
        List arrayWithoutDup1 = new ArrayList(new HashSet(array1));
        List arrayWithoutDup2 = new ArrayList(new HashSet(array2));
        Collections.sort(arrayWithoutDup1);
        Collections.sort(arrayWithoutDup2);

        //output two array lists in ascending order without duplicates
        System.out.println("First Array in ascending order without duplicates: \n" + arrayWithoutDup1 + "\n");
        System.out.println("Second Array in ascending order without duplicates: \n" + arrayWithoutDup2 + "\n");

        List<Integer> list = new ArrayList<Integer>();//new list for merging array1 and array2

        arrayWithoutDup1.removeAll(arrayWithoutDup2);//remove duplicate between arrayWithoutDup1 and arrayWithoutDup2
        list.addAll(arrayWithoutDup1);
        list.addAll(arrayWithoutDup2);//merge

        Collections.sort(list);//sort

        System.out.println("Combined List is: \n" + list);
    }

    /**
     * generate an array list with random integers
     *
     * @return an array list with random integers
     */
    public static ArrayList<Integer> generateArray() {
        ArrayList<Integer> list = new ArrayList<>();
        int number = (int) (Math.random() * 10 + 10);//set the length for array list
        for (int i = 0; i < number; i++) {
            list.add(Generator.generateRandomInteger());//generate random number
        }
        return list;
    }

    /**
     * generate random integer
     *
     * @return a random integer
     */
    public static int generateRandomInteger() {
        return (int) (Math.random() * 100);
    }

}
