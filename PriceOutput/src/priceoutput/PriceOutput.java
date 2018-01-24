/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priceoutput;

/**
 *
 * @author jieni
 */
import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * Input the name, quantity and price of three items. The name may contain
 * spaces. Output a bill with a tax rate of 6.25% within two decimal spaces. The
 * output is formatted in columns.
 *
 * @author jieni
 */
public class PriceOutput {

    static Formatter formatter = new Formatter(System.out);

    /**
     * declare field formatter
     */
    /**
     * @param args[]
     */
    public static void main(String args[]) {

        System.out.println("Input name of item 1:");
        Scanner scanner11 = new Scanner(System.in);
        String itemName1 = scanner11.nextLine();
        /**
         * input string that may contain spaces
         */

        System.out.println("Input quality of item 1:");
        Scanner scanner12 = new Scanner(System.in);
        int itemQuantity1 = scanner12.nextInt();
        /**
         * input integer value
         */

        System.out.println("Input price of item 1:");
        Scanner scanner13 = new Scanner(System.in);
        double itemPrice1 = scanner13.nextDouble();
        /**
         * input double value
         */

        System.out.println("Input name of item 2:");
        Scanner scanner21 = new Scanner(System.in);
        String itemName2 = scanner21.nextLine();

        System.out.println("Input quality of item 2:");
        Scanner scanner22 = new Scanner(System.in);
        int itemQuantity2 = scanner22.nextInt();

        System.out.println("Input price of item 2:");
        Scanner scanner23 = new Scanner(System.in);
        double itemPrice2 = scanner23.nextDouble();

        System.out.println("Input name of item 3:");
        Scanner scanner31 = new Scanner(System.in);
        String itemName3 = scanner31.nextLine();

        System.out.println("Input quality of item 3:");
        Scanner scanner32 = new Scanner(System.in);
        int itemQuantity3 = scanner32.nextInt();

        System.out.println("Input price of item 3:");
        Scanner scanner33 = new Scanner(System.in);
        double itemPrice3 = scanner33.nextDouble();
        /**
         * input completed
         */

        double itemTotal1 = itemQuantity1 * itemPrice1;
        double itemTotal2 = itemQuantity2 * itemPrice2;
        double itemTotal3 = itemQuantity3 * itemPrice3;
        double subTotal = itemTotal1 + itemTotal2 + itemTotal3;
        double tax = subTotal * 0.0625;
        double total = subTotal + tax;
        /**
         * calculate completed
         */

        System.out.println("Your bill:");
        System.out.println("");
        /**
         * enter key
         */

        formatter.format("%-30s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Total");
        formatter.format("%-30s %-10d %-10.2f %-10.2f\n", itemName1, itemQuantity1, itemPrice1, itemTotal1);
        formatter.format("%-30s %-10d %-10.2f %-10.2f\n", itemName2, itemQuantity2, itemPrice2, itemTotal2);
        formatter.format("%-30s %-10d %-10.2f %-10.2f\n", itemName3, itemQuantity3, itemPrice3, itemTotal3);
        formatter.format("%-30s %-10s %-10.2s %-10.2f\n", "Subtotal", "", "", subTotal);
        formatter.format("%-30s %-10s %-10.2s %-10.2f\n", "6.25% saled tax", "", "", tax);
        formatter.format("%-30s %-10s %-10.2s %-10.2f\n", "Total", "", "", total);
        /**
         * formatter class is used to format output in columns by adding blank
         * spaces; s -> string, d -> integer, f -> float/double default -> right
         * aligned, '-' -> left aligned
         */

    }

}
