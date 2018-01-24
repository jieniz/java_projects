/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_task2;

/**
 * an interface to get authorization from the banks
 *
 * @author jieni
 */
public interface Authorization {

    /**
     * confirm with the bank that the credit or check information is right
     */
    public void confirm();

}
