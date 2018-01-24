/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

/**
 *
 * @author jieni
 */
public class A4_Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.printMenu();
        int menuOrder = menu.order();
        while (menuOrder != 4) {
            if (menuOrder == 1) {
                Customer customer = new Customer();
                customer.registerCustomer();
            } else if (menuOrder == 2) {
                Order order = new Order();
                order.setOrder();
                order.setDate();
                order.calcTax();
                order.calcTotal();
                order.calcTotalWeight();
                order.writeOrder();
                Payment payment = new Payment(order.getTotal());
                payment.setType();
                payment.payAmount();
                order.printReceipt(payment.getType(), payment.getCashTendered());
            } else if (menuOrder == 3) {
                Order file = new Order();
                file.printOrderFile();
            }
            menuOrder = menu.order();
        }
    }
}
