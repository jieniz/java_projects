/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

/**
 * details of one item in one order
 *
 * @author jieni
 */
public class OrderDetail {

    private int quantity;
    private String name;
    private final double taxStatus = 0.11;
    private final int bottleWeight = 10;

    /**
     * constructor of two arguments which are the quantity of one item and the
     * item name
     *
     * @param itemQuantity
     * @param itemName
     */
    public OrderDetail(int itemQuantity, String itemName) {
        quantity = itemQuantity;
        name = itemName;
    }

    /**
     * calculate the sub tax of one item based on the tax status
     *
     * @return sub total of tax for one item
     */
    public double calSubTax() {
        Item item = new Item(quantity, name);
        return item.getPriceforQuantity() * taxStatus;
    }

    /**
     * calculate the sub total amount of one item without tax
     *
     * @return
     */
    public double calcSubTotal() {
        Item item = new Item(quantity, name);
        return item.getPriceforQuantity();
    }

    /**
     * calculate the sub weight for one item
     *
     * @return
     */
    public int calcWeight() {
        Item item = new Item(quantity, name);
        return item.getWeight(quantity) + quantity * bottleWeight;
    }

}
