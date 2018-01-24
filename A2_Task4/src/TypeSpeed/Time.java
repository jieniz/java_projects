/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeSpeed;

import java.util.Date;

/**
 * get the present time as milliseconds
 *
 * @author jieni
 */
public class Time {

    /**
     * get the present time
     *
     * @return time - present time as milliseconds
     */
    public long getTime() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }

}
