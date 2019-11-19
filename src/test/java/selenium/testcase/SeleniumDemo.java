package selenium.testcase;

public class SeleniumDemo {
    public static  String baseUrl="http://www.baidu.com";
    public static void main(String[] args){
        String path="/Users/liuqi/360yunpan/workspace/XUnit/src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver",path);
//        WebDriver driver = new ChromeDriver();
//        driver.get(baseUrl);
    }
}
