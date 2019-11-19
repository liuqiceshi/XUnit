import org.junit.*;

import static org.junit.Assert.assertTrue;

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
