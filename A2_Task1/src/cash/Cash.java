/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cash;

/**
 * Objects of the Cash class represent amounts of Australian money.The class has
 * two fields of type int for the dollars and cents in the amount of money as
 * well as several methods.
 *
 * @author jieni
 */
public class Cash {

    private int cashDollars;
    private int cashCents;
    //fields of type int for the dollars and cents in the amount of money
    //use setter and getter methods to get access to private values

    /**
     * the constructor of class Cash with two arguments
     *
     * @param dollars the amount of dollars
     * @param cents the amount of cents
     */
    public Cash(int dollars, int cents) {
        cashDollars = dollars;
        cashCents = cents;
    }

    /**
     * setter method with two arguments of type int for the dollars and cents
     *
     * @param cashDollars the amount of dollars
     * @param cashCents the amount of cents
     */
    public void setCash(int cashDollars, int cashCents) {
        this.cashDollars = cashDollars;
        this.cashCents = cashCents;
    }

    /**
     * setter method with one argument of type int for an amount of dollars with
     * zero cents
     *
     * @param cashDollars the amount of dollars
     */
    public void setCashDollar(int cashDollars) {
        this.cashDollars = cashDollars;
        this.cashCents = 0;
    }

    /**
     * getter method to get the value of field cashDollars in Cash class
     *
     * @return cashDollars
     */
    public int getCashDollars() {
        return cashDollars;
    }

    /**
     * getter method to get the value of field cashCents in Cash class
     *
     * @return cashCents
     */
    public int getCashCents() {
        return cashCents;
    }

    /**
     * display the value of dollars and cents
     *
     */
    public void display() {
        System.out.println("the value of dollars is " + cashDollars + " and the value of cent is " + cashCents + "\n");
    }//display method: print the value of dollars and cents for the Cash object

    /**
     * add method for the addition of amounts of money(have two arguments of
     * type Cash and return a value of type Cash)
     *
     * @param cash1 object of Cash class
     * @param cash2 object of Cash class
     * @return cash1
     */
    public static Cash add(Cash cash1, Cash cash2) {
        int dollarValue1 = cash1.getCashDollars() + cash2.getCashDollars();
        int centValue1 = cash1.getCashCents() + cash2.getCashCents();
        Cash cash = new Cash(dollarValue1, centValue1);
        return cash;
    }

    /**
     * minus method for subtraction of amounts of money(have two arguments of
     * type Cash and return a value of type Cash)
     *
     * @param cash3 object of Cash class
     * @param cash4 object of Cash class
     * @return cash3
     */
    public static Cash minus(Cash cash3, Cash cash4) {
        int dollarValue2 = cash3.getCashDollars() - cash4.getCashDollars();
        int centValue2 = cash3.getCashCents() - cash4.getCashCents();
        cash3.setCash(dollarValue2, centValue2);
        return cash3;
    }

    /**
     * a second version for addition, use a calling object and a single
     * argument, the result is given as the changed value of the calling object
     *
     * @param cash object of cash Class
     */
    public void add(Cash cash) {
        cashDollars = cash.getCashDollars() + cashDollars;
        cashCents = cash.getCashCents() + cashCents;
    }

    /**
     * a second version for subtraction, use a calling object and a single
     * argument, the result is given as the changed value of the calling
     *
     * @param cash object of Cash class
     */
    public void minus(Cash cash) {
        cashDollars = cashDollars - cash.getCashDollars();
        cashCents = cashCents - cash.getCashCents();
    }

    /**
     * equals method is to compares if the value of dollars and cents in both
     * objects are the same and returns a boolean (take an argument of type
     * Cash)
     *
     * @param cash object of Cash class
     * @return equal
     */
    public boolean equals(Cash cash) {
        boolean equal = false;
        if ((cash.getCashCents() == cashCents) && (cash.getCashDollars() == cashDollars)) {
            equal = true;
        }
        return equal;
    }

}
