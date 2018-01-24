/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

/**
 * simulate the situation of a playground which a smart dog moves on.
 *
 * @author jieni
 */
public class Playground {

    private int[][] floor = new int[25][25];

    /**
     * initialize floor array by setting all the values to 0.
     */
    public void initializeFloor() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                floor[i][j] = 0;
            }
        }
    }

    /**
     * set the value of the floor array from an input
     *
     * @param f the value of the floor array
     */
    public void setFloor(int[][] f) {
        floor = f;
    }

    /**
     * get the value of the floor array
     *
     * @return the value of the floor array
     */
    public int[][] getFloor() {
        return floor;
    }
}
