/*
 * Created on 2014/01/09
 */
package org.ryu1.jmockit.sample;

/**
 * 
 * @since TODO for ryu
 * @version $Id$
 * @author ryu
 */
public class BusinesLogic {
    
    private Stub stub = null;
    
    
    /**
     */
    public void registUser(User user) {
        int result = stub.putUser(user);
        
        if (result == 200) {
            System.out.println("成功しました。");
        } else {
            System.out.println("失敗しました。");
        }
    }
}
