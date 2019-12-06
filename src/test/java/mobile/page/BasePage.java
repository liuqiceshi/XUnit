package mobile.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public static AndroidDriver driver;



    public static  WebElement findElement(By by){
        try {
            return  driver.findElement(by);
        }catch (Exception e){
            handAlert();
            return driver.findElement(by);
        }

    }
    //click时出现异常
    public static  void findEementAndClick(By by){
        try {
            driver.findElement(by).click();
        }catch (Exception e){
            handAlert();
            driver.findElement(by).click();
        }
    }

    //处理alert框 TODO 不需要判断所有的alert都存在
    public static void handAlert() {
        List<By> alterBoxs = new ArrayList<By>();
        alterBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        // alterBoxs.add(By.id("dddd"));
        alterBoxs.forEach(alert -> {
            //速度会比较慢
            By adsLocator = alert;
            List<WebElement> list = driver.findElements(adsLocator);
            if (list.size() >= 1) {
                list.get(0).click();
            }
        });
    }
   // LogEntries logEntries = driver.manage().logs().get("driver");
}
