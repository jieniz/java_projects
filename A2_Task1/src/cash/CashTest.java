/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cash;

/**
 * test Cash class to demonstrate that all the methods in Cash class work as
 * expected.
 *
 * @author jieni
 */
public class CashTest {

    /**
     * test the methods in Cash class
     *
     * @param args
     */
    public static void main(String args[]) {

        Cash cash = new Cash(0, 0);//create an object cash that represents amount of Australia money
        cash.setCash(50, 30);
        System.out.println("set the value of cash:");
        cash.display();

        cash.setCashDollar(80);
        System.out.println("change the value of cash:");
        cash.display();

        Cash cash1 = new Cash(100, 90);//create an object cash1 with fields 100,90
        System.out.println("set the value of cash1:");
        cash1.display();
        Cash cash2 = new Cash(20, 80);//create an object cash2 with fields 20,80
        System.out.println("set the value of cash2:");
        cash2.display();

        cash = Cash.add(cash1, cash2);
        System.out.println("the addition of cash1 and cash2 (the results is in cash): ");
        cash.display();

        cash = Cash.minus(cash1, cash2);
        System.out.println("the subtraction of cash1 and cash2 (the results is in cash): ");
        cash.display();

        cash1.add(cash2);
        System.out.println("the addition of cash1 and cash2 (the results is in cash1): ");
        cash1.display();

        cash1.minus(cash2);
        System.out.println("the subtraction of cash1 and cash2 (the results is in cash1): ");
        cash1.display();

        boolean equal1 = cash.equals(cash1);
        System.out.println("the dollars and cents of cash and cash1 are the same : " + equal1);

        boolean equal2 = cash.equals(cash2);
        System.out.println("the dollars and cents of cash and cash2 are the same : " + equal2);
        System.out.println("");

    }

}
