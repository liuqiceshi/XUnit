package testStudy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//运行器 套件
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestJUnit4DemoChildren2.class,
        TestJUnit4Demo.class,
        TestJUnit4DemoChildren.class
})


public class TestSuites {

}
