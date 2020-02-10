package until;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author liuqi
 * @Date 20/2/3 22:13
 * @Version 1.0
 * @Description:
 */
public class DateUtile {
    //根据不同格式获取不同日期
    public static String date (String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
}
