/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceRoll;

/**
 * simulate the rolling of one dice
 *
 * @author jieni
 */
public class Dice {

    /**
     * simulate one rolling of one dice
     *
     * @return dice - the result of one dice
     */
    public int rollDice() {
        
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }

}
