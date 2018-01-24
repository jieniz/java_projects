/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

/**
 * simulate the movement of Sherlock which is a smart dog with a marker that
 * walks around a playground following instructions from its owner, create and
 * display different figures as he marks shapes on the playground floor with his
 * marker.
 *
 * @author jieni
 */
public class A3_Task1 {

    /**
     * read and store commands from the user into an array and execute them one
     * by one.
     *
     * @param args main method
     */
    public static void main(String[] args) {

        Controller controller = new Controller();//create an object controller from class Controllor
        controller.readCommand();//read commands from an user until 9 shows up and store them into command array

        Dog sherlock = new Dog();//create an object sherlock from class Dog
        Playground playground = new Playground();//create an object playground from class Playground
        playground.initializeFloor();//set all values of floor array that represents a playground into 0
        sherlock.setFloor(playground.getFloor());//transmit the value of floor array from playground to sherlock

        for (int i = 0; i < controller.getLength(); i++) {//read the value from command array and execute it one by one

            switch (controller.getCommandArray()[i]) {
                case 1:
                    sherlock.command1();
                    continue;
                case 2:
                    sherlock.command2();
                    continue;
                case 3:
                    sherlock.command3();
                    continue;
                case 4:
                    sherlock.command4();
                    continue;
                case 5:
                    sherlock.command5(controller.getCommandArray()[i + 1]);//transmit next value that represents the spaces in the command array
                    i++;//skip next value that has already used as moving spaces
                    continue;
                case 6:
                    sherlock.command6();
                case 9:
                    break;//when 9 shows up, stop the program
            }
        }
    }

}
