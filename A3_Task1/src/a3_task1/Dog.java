/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

/**
 * simulate a smart dog walking around a playground following commands from the
 * user.
 *
 * @author jieni
 */
public class Dog {

    private int marker = 1;//start with marker up
    private int[][] floor = new int[25][25];
    private int positionx = 0;//start at position(0,0)
    private int positiony = 0;
    private int direction = 0;//the walking direction of the dog

    /**
     * get the value of a 2d array (25 rows and 25 columns) that represents the
     * playground.
     *
     * @return a 2d array representing the playground
     */
    public int[][] getFloor() {
        return floor;
    }

    /**
     * set the value of the floor array from an input.
     *
     * @param f the value of floor array that we want to send
     */
    public void setFloor(int[][] f) {
        floor = f;
    }

    /**
     * get the value of the dog's position of one direction to keep track of its
     * current position.
     *
     * @return the position of one direction
     */
    public int getPositionx() {//keep track of the current position of Sherlock
        return positionx;
    }

    /**
     * get the value of the dog's position of another direction to keep track of
     * its current position.
     *
     * @return the position of another direction
     */
    public int getPositiony() {//keep track of the current position of Sherlock
        return positiony;
    }

    /**
     * get the value of marker, 1 means up and 2 means down.
     *
     * @return the value of marker (1 or 2)
     */
    public int getMarker() {//keep track of the marker, up or down
        return marker;
    }

    /**
     * execute command 1, turn marker up.
     */
    public void command1() {
        marker = 1;//set the value of marker to 1
    }

    /**
     * execute command 2, turn marker down.
     */
    public void command2() {
        marker = 2;//set the value of marker to 2
    }

    /**
     * execute command 3, make the dog turn right.
     */
    public void command3() {
        if (direction < 3) {//set the default direction to 0 and other directions to 1,2,3 clockwise
            direction++;//when the dog turn right, the value of direction plus 1
        } else {
            direction = 0;//if the current value of direction is 3, set the value to 0 again
        }
    }

    /**
     * execute command 4, make the dog turn left.
     */
    public void command4() {
        if (direction > 0) {//when the dog turn right, the value of direction plus 1
            direction--;
        } else {
            direction = 3;//if the current value of direction is 0, set the value to 3 again
        }
    }

    /**
     * execute command 5, get the value of n next and move forward n spaces.
     *
     * @param n the value of spaces moving forward
     */
    public void command5(int n) {

        if (marker == 1) {//if the marker is up, move forward n spaces without marking shapes

            switch (direction) {//the next position of the dog depends on the current direction
                case 0:
                    positiony = positiony + n;//the direction is right, y+n
                    if(positiony >= 25){//if the spaces exceeds, move to the last possible location in that direction and go to the next command
                        positiony = 24;
                    }
                    break;
                case 1:
                    positionx = positionx + n;//the direction is down, x+n
                    if(positionx >= 25){
                        positionx = 24;
                    }
                    break;
                case 2:
                    positiony = positiony - n;//the direction is left, y-n
                    if(positiony < 0){
                        positiony = 0;
                    }
                    break;
                case 3:
                    positionx = positionx - n;//the direction is up, x-n
                    if(positionx < 0){
                        positionx = 0;
                    }
                    break;
            }
        }
        if (marker == 2) {//if the marker is up, move forward n spaces and mark shapes as well

            switch (direction) {//the next position of the dog depends on the current direction
                case 0:
                    int p0 = positiony;
                    positiony = p0 + n;
                    if(positiony >= 25){
                        positiony = 24;
                    }
                    for (int i = p0; i <= positiony; i++) {//set the value of floor[x][y] to 1 if the dog moved with marker up
                        floor[positionx][i] = 1;
                    }
                    break;
                case 1:
                    int p1 = positionx;
                    positionx = positionx + n;
                    if(positionx >= 25){
                        positionx = 24;
                    }
                    for (int j = p1; j <= positionx; j++) {
                        floor[j][positiony] = 1;
                    }
                    break;
                case 2:
                    int p2 = positiony;
                    positiony = positiony - n;
                    if(positiony < 0){
                        positiony = 0;
                    }
                    for (int i = p2; i >= positiony; i--) {
                        floor[positionx][i] = 1;
                    }
                    break;
                case 3:
                    int p3 = positionx;
                    positionx = positionx - n;
                    if(positionx < 0){
                        positionx = 0;
                    }
                    for (int j = p3; j >= positionx; j--) {
                        floor[j][positiony] = 1;
                    }
                    break;
            }
        }
    }

    /**
     * execute command 6, print and display the marking shape.
     */
    public void command6() {

        System.out.println("\nThe drawing is: \n");

        for (int i = 0; i < 25; i++) {//if the value of floor[][] is 1, print "* "; otherwise, print "  "
            for (int j = 0; j < 25; j++) {
                if (floor[i][j] == 0) {
                    System.out.print("  ");
                } else if (floor[i][j] == 1) {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }

    }
}
