package mobile.testcase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.page.App;
import mobile.page.BasePage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class XueQiu extends BasePage {

    @BeforeClass
    public static void beforeAll() throws Exception {
        App.start();
        driver.findElement(By.id("com.xueqiu.android:id/image_cancel")).click();
    }
    @Test
    public void testSwipe() throws InterruptedException {

      for(int i=0;i<20;i++){
          scroll(0.8, 0.8,0.4,0.4);
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
