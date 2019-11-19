package mobile.page;

import org.openqa.selenium.By;

public class SearchPage extends  BasePage{
    //找到搜索框 输入关键字 点击股票
   public SearchPage search(String keyword){
       findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
       findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
       findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView")).click();
       return this;
   }
   //获取列表股票中文名字
   public  String  getStockList(){
       return  findElement(By.id("stockName")).getText();
   }
   //获取价每支股票价格
    public float getCurrentPrice() {
        return  Float.valueOf(findElement(By.id("com.xueqiu.android:id/current_price")).getText());
    }
}
