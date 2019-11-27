package mobile.testcase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.page.App;
import mobile.page.BasePage;
import org.aspectj.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class XueQiu extends BasePage {

    @BeforeClass
    public static void beforeAll() throws Exception {
        App.start();
        driver.findElement(By.id("com.xueqiu.android:id/image_cancel")).click();
    }

    /**
     * 模拟器模拟发送短信和打电话
     */
    @Test
    public void testCall(){
        driver.sendSMS("13141322817","hello liuqi");
        driver.makeGsmCall("13141322817", GsmCallActions.CALL);

    }


    /**
     * 获取设备信息
     */
    @Test
    public void testDevice() throws InterruptedException {
        driver.runAppInBackground(Duration.ofSeconds(5));
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(3000);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.openNotifications();
        Thread.sleep(3000);
        driver.manage().logs().getAvailableLogTypes().forEach(x->System.out.println(x));
        System.out.println(driver.getBatteryInfo().getState().ordinal());
        System.out.println(driver.getPerformanceData("com.xueqiu.android","cpuinfo",5));

    }

    /**
     * 屏幕滑动并且截图
     * @throws InterruptedException
     */
    @Test
    public void testSwipe() throws InterruptedException, IOException {

      for(int i=0;i<5;i++){
          scroll(0.8, 0.8,0.4,0.4);
          FileUtil.copyFile(
                  driver.getScreenshotAs(OutputType.FILE).getCanonicalFile(),
                  new File(i+".png")
          );
          System.out.println("滚动"+i+"次");

      }

    }
    public void scroll(Double startX, Double startY,Double endX, Double endY) throws InterruptedException {
            TouchAction touchAction = new TouchAction(App.driver);
            Dimension size=App.driver.manage().window().getSize();
            Duration duration=Duration.ofMillis(500);
            touchAction
                    .press(PointOption.point((int)(size.width*startX), (int)(size.height*startY)))
                    .waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point((int)(size.width*endX), (int)(size.height*endY)))
                    .release().perform();

            Thread.sleep(1000);

    }

}
