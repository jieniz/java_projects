/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * create a text file named homeworkExcuses
 *
 * @author jieni
 */
public class ExcuseFile {

    /**
     * create a text file named homeworkExcuses
     *
     * @throws FileNotFoundException
     */
    public ExcuseFile() throws FileNotFoundException {
        File file = new File("homeworkExcuses.txt");
        PrintWriter output = new PrintWriter(file);

        output.println("Homework Excuses");
        output.close();

    }
}
