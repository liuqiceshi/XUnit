package testStudy;
/**
 * @Author: liuqi
 * @Description: junit4基础练习
 * @Date: Create in  2019/12/19
 *
 */

import org.junit.*;

import static org.junit.Assert.*;

public class TestJUnit4Demo {

    @BeforeClass
    public static void beforeAllTestCase(){
        System.out.println("i am @BeforeClass");
    }

    @AfterClass
    public static  void afterAllTestCase(){
        System.out.println("i am @AfterClass");
    }

    @Before
    public void beforeTestCase(){
        System.out.println("I am @Before");

    }
    @After
    public void afterTestCase(){
        System.out.println("I am @Aefter");
    }


    @Test
    public void testDemo1(){
        System.out.println("i am testDemo1");
        assertTrue(true);
        //assertSame();
        //assertEquals();
    }
    @Test
    public  void testDemo2(){
        System.out.println("i am testDemo2");
        //assertTrue(false);
    }
    @Test
    public void testDemo3(){
        System.out.println("i am testDemo3");
        //assertTrue(false);
    }

}
