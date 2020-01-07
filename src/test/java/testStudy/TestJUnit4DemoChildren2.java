package testStudy;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestJUnit4DemoChildren2 extends TestJUnit4Demo{

    @BeforeClass
    public static void beforeAllTestCaseChildren(){
        System.out.println("i am children2 @BeforeClass");
    }

    @AfterClass
    public static  void afterAllTestCaseChildren(){
        System.out.println("i am children2 @AfterClass");
    }

    @Before
    public void beforeTestCaseChildren(){
        System.out.println("i am children2 @Before");

    }
    @After
    public void afterTestCaseChildren(){
        System.out.println("i am children2 @Aefter");
    }


    @Test
    public void testDemo1Children(){
        System.out.println("i am children2 testDemo1");
        assertTrue(true);

    }
    @Test
    public  void testDemo2Children(){
        System.out.println("i am children2 testDemo2");
        //assertTrue(false);

    }
    @Test
    public void testDemo3Children(){
        System.out.println("i am children2 testDemo3");
        //assertTrue(false);

    }

}
