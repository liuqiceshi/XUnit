package mobile.testcase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class XueQiu extends BasePage {
    private Duration duration;

    @BeforeClass
    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
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
        driver.findElement(By.id("com.xueqiu.android:id/image_cancel")).click();
    }

    /**
     * toast 识别
     */
    @Test
    public void testToast(){
       System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
    }


    /**
     * 获取当前页面的架构支持 NATIVE_APP  Hybrid   Web App
     */
    @Test
    public void testContextHandles(){
       Set<String> contextNames=driver.getContextHandles();
       for(String contextName:contextNames){
           System.out.println("当前页面架构:"+contextName);
       }
       /*driver.context( contextNames.toArray()[1].toString());

       for(Object e : driver.findElementsByXPath("//*")){

       }*/
       //driver.context("NATIVE_APP");
    }

    /**
     * WebView的案例
     */
    @Test
    public void testWebView(){
        //driver.findElementByXPath("//*[@text='交易']").click();
        testContextHandles();
        driver.findElementByXPath("//android.widget.TextView[@text='沪深' and @resource-id='com.xueqiu.android:id/button_text']" ).click();
        testContextHandles();
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
     * 设备信息
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

    /**
     * 屏幕横竖屏
     */
    @Test
    public void testRotate() throws InterruptedException {
        System.out.println("当前的activity是："+driver.currentActivity());
        System.out.println("当前的网络是："+driver.getConnection());
        System.out.println("当前横竖屏状态："+driver.getOrientation().name());
        //横屏
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(5000);
        //竖屏
       // driver.rotate(ScreenOrientation.PORTRAIT);
    }

    /**
     * 日志
     */
    @Test
    public void testLog(){
        System.out.println("日志"+driver.manage().logs().getAvailableLogTypes());
        for(Object logcat:driver.manage().logs().get("logcat").getAll().toArray()){
            System.out.println(logcat);
        }
    }

    /**
     * 获取性能获取性能数据类型 内存、CPU、电量、网络
     */
    @Test
    public void testPerformance(){
        System.out.println(driver.getSupportedPerformanceDataTypes());
        System.out.println(driver.getPerformanceData("com.xueqiu.android","memoryinfo",10));
        System.out.println(driver.getPerformanceData("com.xueqiu.android","cpuinfo",100));
        System.out.println(driver.getPerformanceData("com.xueqiu.android","batterinfo",100));
        System.out.println(driver.getPerformanceData("com.xueqiu.android","networkinfo",100));
    }


    public void scroll(Double startX, Double startY,Double endX, Double endY) throws InterruptedException {
            TouchAction touchAction = new TouchAction(App.driver);
            Dimension size=App.driver.manage().window().getSize();
            duration=Duration.ofMillis(500);
            touchAction
                    .press(PointOption.point((int)(size.width*startX), (int)(size.height*startY)))
                    .waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point((int)(size.width*endX), (int)(size.height*endY)))
                    .release().perform();
            Thread.sleep(1000);
    }

}
