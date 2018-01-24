/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task1;

import java.io.FileNotFoundException;

/**
 * edit text files for extra blanks by replacing any string of two or more
 * blanks with a single blank.
 *
 * @author jieni
 */
public class A4_Task1 {

    /**
     * edit text files for extra blanks by replacing any string of two or more
     * blanks with a single blank.
     *
     * @param args name of the edited file
     *
     */
    public static void main(String[] args) {

        TaskFile taskFile = new TaskFile();//create an object of the TaskFile class

        taskFile.createTempFile();//create a temporary file
        taskFile.setFileName();//get input as the edited file name
        try {//catch and handle the exception that may be thrown from used methods
            taskFile.copyFiletoTemp();//copy the content from the edited file to temporary file without extra blanks
            taskFile.copyTemptoFile();//copy the content from the temporary file to the edited file
        } catch (FileNotFoundException ex) {//if the temporary file or edited file do not exist, throw an exception
            System.out.println("Exception: The file does not exist.");
            System.out.println("Please try again...");
            System.exit(0);
        }

        taskFile.deleteTempFile();//delete the temporary file
    }

}
