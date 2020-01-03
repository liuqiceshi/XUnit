package study;

import java.util.Properties;

/**
 * @Author liuqi
 * @Date 19/12/26 15:26
 * @Version 1.0
 * @Description:
 */
public class PropertiesDemo {
    public static void main (String[] args){
        Properties p=new Properties();
        p.setProperty("username","zhangsan");
        p.setProperty("password","123456");
        System.out.println("p的值："+p);
        System.out.println("获取用户名："+p.getProperty("username"));


    }
}
