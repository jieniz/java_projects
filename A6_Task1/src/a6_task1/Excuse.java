/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * read from a text file and output 15 words appears most in the text file
 *
 * @author jieni
 */
public class Excuse {

    Map<String, Integer> hashMap;
    Map<String, Double> hashMap2;
    List<Map.Entry<String, Double>> list;

    /**
     * read from a text file and store into hashMap( (word as key and frequency
     * as value)
     *
     * @param fileName the name of the text file
     */
    public void readFile(String fileName) {
        File file = new File(fileName);
        hashMap = new HashMap<>();

        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String temp = input.next();
                if (!hashMap.containsKey(temp)) {//if hashMap does not contain the String, store it as key and 1 as value
                    hashMap.put(temp, 1);
                } else {//if hashMap contains the String, value +1
                    int value = hashMap.get(temp);
                    value++;
                    hashMap.put(temp, value);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     * change the value from times to frequency percentage
     */
    public void appear() {

        double sum = 0;
        hashMap2 = new HashMap<>();
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();//set entry set of hashMap

        for (Map.Entry<String, Integer> entry : entrySet) {//calculate the total number of words
            sum = sum + entry.getValue();
        }

        for (Map.Entry<String, Integer> entry : entrySet) {
            double value = entry.getValue() / sum;//calculate the percentage of one word appears
            hashMap2.put(entry.getKey(), value);//store value
        }
    }

    /**
     * display 15 words that appears most and their percentage
     */
    public void display() {
        list = new ArrayList<Map.Entry<String, Double>>(hashMap2.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {//compare, sort and store in a list
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.printf("%-10s %-10s\n", "WORD", "FREQUENCY");
        System.out.printf("%-20s\n", "====================");
        for (int i = list.size() - 1; i >= list.size() - 15; i--) {

            String text = list.get(i).toString();
            String[] texta = text.split("=");
            double d = Double.parseDouble(texta[1]) * 100;

            System.out.printf("%-10s %-4.2f%-2s\n", texta[0], d, "%");
        }
    }
}
