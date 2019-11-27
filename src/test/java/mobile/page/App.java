package mobile.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {


    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        //Enable Unicode input, default false
        desiredCapabilities.setCapability("unicodeKeyboard","true");
        //Reset keyboard to its original state, after running Unicode tests with unicodeKeyboard capability. Ignored if used alone. Default false
        desiredCapabilities.setCapability("unicodeKeyboard","true");
        //noRest值为true时缓存、权限被清空 ，false时保留缓存数据
        desiredCapabilities.setCapability("noRest",false);
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    //进入搜索框
    public static SearchPage toSearch() {
       findEementAndClick(By.id("com.xueqiu.android:id/home_search"));
       //driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
       return new SearchPage();
    }


}
