/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeSpeed;

import java.util.Scanner;

/**
 * test how fast you can type the following lines: How much wood would a
 * woodchuck chuck if a woodchuck could chuck wood? He would chuck as much wood
 * as a woodchuck would if a woodchuck could chuck wood
 *
 * @author jieni
 */
public class TypeSpeed {

    /**
     * the time when the user start typing
     */
    public long start = 0;
    /**
     * the time when the user end typing
     */
    public long end = 0;

    /**
     * display the content for the user
     */
    public void outputTask() {
        System.out.println("--Your job is to type the following paragraph as fast as you can:\n"
                + "How much wood would a woodchuck chuck if a woodchuck could chuck wood? "
                + "He would chuck as much wood as a woodchuck would if a woodchuck could chuck wood\n"
                + "--When you are ready, press enter, type the lines, and press enter again.\n"
                + "--Now press enter...");
    }

    /**
     * check if the input is enter key; if so, calculate the start time using
     * Time class
     *
     */
    public void timeStart() {

        Scanner scanner1 = new Scanner(System.in);
        String key = scanner1.nextLine();
        if (key.length() == 0) {
            Time startTime = new Time();
            start = startTime.getTime();
        }
    }

    /**
     * check if the input line is in accordance with the task; if so, calculate
     * the end time using Time class
     *
     */
    public void timeEnd() {

        Scanner scanner2 = new Scanner(System.in);
        String line = scanner2.nextLine();
        if ("How much wood would a woodchuck chuck if a woodchuck could chuck wood? He would chuck as much wood as a woodchuck would if a woodchuck could chuck wood".equals(line)) {
            Time endTime = new Time();
            end = endTime.getTime();
            System.out.println("\nCongratulations! Your input is correct.\nThe time you took to type the sentence is " + (end - start) + " milliseconds.\n");

        } else {
            System.out.println("\nSorry, your input is incorrect. Please try again.");
        }

    }

}
