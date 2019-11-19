import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestJUnit4DemoChildren extends TestJUnit4Demo{

    @BeforeClass
    public static void beforeAllTestCaseChildren(){
        System.out.println("i am children @BeforeClass");
    }

    @AfterClass
    public static  void afterAllTestCaseChildren(){
        System.out.println("i am children @AfterClass");
    }

    @Before
    public void beforeTestCaseChildren(){
        System.out.println("i am children @Before");

    }
    @After
    public void afterTestCaseChildren(){
        System.out.println("i am children @Aefter");
    }


    @Test
    public void testDemo1Children(){
        System.out.println("i am children testDemo1");
        assertTrue(true);

    }
    @Test
    public  void testDemo2Children(){
        System.out.println("i am children testDemo2");
        //assertTrue(false);

    }
    @Test
    public void testDemo3Children(){
        System.out.println("i am children testDemo3");
        //assertTrue(false);

    }

}
