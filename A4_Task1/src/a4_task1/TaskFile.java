/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * edit text files for extra blanks using a temporary file.
 *
 * @author jieni
 */
public class TaskFile {

    private String fileName;//name of the edited file
    private File file;//object file
    private File temp;//object temporary file

    /**
     * ask the user and take as input the name of the file to be edited.
     *
     * \
     */
    public void setFileName() {
        System.out.print("Please enter the name of the text file without suffix that you want to edit: ");
        Scanner input = new Scanner(System.in);//create a scanner object to read inputs 
        fileName = input.next() + ".txt";//get the file name
        file = new File(fileName);//create an instance of file
        while (!file.exists() || temp.getName().equals(fileName)) {//if the input does not exist or equals to the name of temporary file, throw an exception
            System.out.println("Exception: The file name of " + fileName + " does not exist.");
            System.out.println("Please try again...");
            System.out.print("Please enter the name of the text file without suffix that you want to edit: ");
            fileName = input.next() + ".txt";
            file = new File(fileName);
            
        }//do not have to condisder the situation that the file name is the same as a directory because the suffix is .txt all the time
    }

    /**
     * get the String of the edited file name
     *
     * @return name of the edited file
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * print the absolute path of a file on the console
     */
    public void printPath() {
        System.out.println("The path of " + fileName + " is " + file.getAbsolutePath() + ".");
    }

    /**
     * create a temporary file using random numbers
     *
     *
     */
    public void createTempFile() {
        String s = "";
        do {
            Random rand = new Random();
            int i = rand.nextInt();
            s = "temp" + i + ".txt";
            temp = new File(s);
        } while (temp.exists());//make sure that there is no other file with the same name.
    }

    /**
     * Copy from the file to the temporary file without extra blanks
     *
     * @throws FileNotFoundException
     */
    public void copyFiletoTemp() throws FileNotFoundException {
        try (
                Scanner input = new Scanner(file);//create scanner of the source file
                PrintWriter output = new PrintWriter(temp);//create printwriter of the temporary file
                ) {
            if (!file.exists() || !temp.exists()) {//if edited file and temporary file do not exist, throw an exception
                throw new FileNotFoundException("File does not exist.");
            }
            String s = "";
            while (input.hasNext()) {//while there are next lines in the file, copy the lines
                s = s + input.nextLine() + "\n";
            }
            output.println(s.replaceAll("\t+", " ").replaceAll(" +", " "));//replace several blanks or tabs by one blank
        }
    }

    /**
     * Copy the contents of the temporary file back into the original file
     *
     * @throws FileNotFoundException
     */
    public void copyTemptoFile() throws FileNotFoundException {
        try (
                Scanner input = new Scanner(temp);
                PrintWriter output = new PrintWriter(file);) {
            if (!file.exists() || !temp.exists()) {//if edited file and temporary file do not exist, throw an exception
                throw new FileNotFoundException("File does not exist.");
            }
            String s = "";
            while (input.hasNext()) {
                s = s + input.nextLine() + "\n";
            }
            output.println(s);//use String s as the input of edited file
        }
    }

    /**
     * delete the temporary file
     */
    public void deleteTempFile() {
        temp.deleteOnExit();
    }

}
