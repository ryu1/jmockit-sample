/*
 * Created on 2014/01/09
 */
package org.ryu1.jmockit.sample;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO for ryu
 * 
 * @since TODO for ryu
 * @version $Id$
 * @author ryu
 */
public class BusinesLogicTest {
    
    /**
     * TODO for ryu
     * 
     * @throws java.lang.Exception
     * @since TODO
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    /**
     * TODO for ryu
     * 
     * @throws java.lang.Exception
     * @since TODO
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    @Mocked
    Stub stub;
    
    BusinesLogic logic = new BusinesLogic();
    
    User user = new User();
    
    
    /**
     * TODO for ryu
     * 
     * @throws java.lang.Exception
     * @since TODO
     */
    @Before
    public void setUp() throws Exception {
        // Deencapsulationは、名前の通りカプセル化を完全無視できます。
        // setFieldでprivate fieldに好きな値を代入できる。
        Deencapsulation.setField(logic, "stub", stub);
        user.setId(1);
        user.setName("James");
    }
    
    /**
     * TODO for ryu
     * 
     * @throws java.lang.Exception
     * @since TODO
     */
    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test method for {@link org.ryu1.jmockit.sample.BusinesLogic#registUser(org.ryu1.jmockit.sample.User)}.
     */
    @Test
    public void testRegistUser() {
        
        // モックオブジェクトに対して期待動作を宣言
        new Expectations() {
            
            {
                stub.putUser(user);
                result = 200;
            }
        };
        
        logic.registUser(user);
    }
    
}
