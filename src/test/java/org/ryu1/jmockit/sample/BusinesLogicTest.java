/*
 * Created on 2014/01/09
 */
package org.ryu1.jmockit.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
    
    /***/
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    /***/
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    // グローバルなモックオブジェクト
    @Mocked
    Stub stub;
    
    BusinesLogic logic = new BusinesLogic();
    
    User user = new User();
    
    
    /***/
    @Before
    public void setUp() throws Exception {
        // Deencapsulationは、名前の通りカプセル化を完全無視できます。
        // setFieldでprivate fieldに好きな値を代入できる。
        Deencapsulation.setField(logic, "stub", stub);
        user.setId(1);
        user.setName("James");
    }
    
    /***/
    @After
    public void tearDown() throws Exception {
    }
    
    /***/
    @Test
    public void testRegistUser_501エラーを発生させる() {
        final BusinesLogic logic2 = new BusinesLogic();
        final User user1 = new User();
        user1.setId(1);
        user1.setName("James");
        // モックオブジェクトに対して期待動作を宣言
        new Expectations() {
            
            // ローカルなモックオブジェクトとして宣言
            Stub stub;
            {
                setField(logic2, "stub", stub);
                stub.putUser(user1);
                result = 501;
            }
        };
        logic2.registUser(user1);
    }
    
    /***/
    @Test
    public void testRegistUser_ユーザーの登録に成功する() {
        
        // モックオブジェクトに対して期待動作を宣言
        new Expectations() {
            
            {
                stub.putUser(user);
                result = 200;
            }
        };
        
        logic.registUser(user);
    }
    
    /***/
    @Test
    public void testRegistUser_例外を発生させる() {
        
        // モックオブジェクトに対して期待動作を宣言
        new Expectations() {
            
            {
                stub.putUser(user);
                result = 200;
                result = 404;
                // 例外を投げる
                result = new RuntimeException("test");
            }
        };
        
        logic.registUser(user);
        logic.registUser(user);
        try {
            logic.registUser(user);
            fail();
        } catch (RuntimeException e) {
            assertEquals("test", e.getMessage());
        }
        
    }
}
