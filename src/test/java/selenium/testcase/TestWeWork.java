package selenium.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeWork {
    public static String baseUrl="https://work.weixin.qq.com/";



    @Before
    public void before(){

    }
    @Test
    public void testStrat(){
        String path="/Users/liuqi/360yunpan/workspace/XUnit/src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

    }
    @After
    public void after(){

    }
}
