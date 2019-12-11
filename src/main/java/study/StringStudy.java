package study;

import static java.lang.System.*;

public class StringStudy {
    /**
     * @Author: liuqi
     * @Description:
     * @Date: Create in  2019/12/12
     * String 类学习
     */
    public static void main(String[] args){
        //将char转为String类型
        char[] helloArray={'l','o','v','e'};
        String helloString=new String(helloArray);
        out.println(helloString);
        out.println("长度："+helloString.length());
        out.println("连接："+helloString.concat("you"));

        //split
        String address=new String("103.25.28.27");
        String[] splitAddress=address.split("\\.");
        for(String s:splitAddress){
            out.println("地址是："+s);

        }
        //== 比较两个对象是否引用同一个实例 equals 比较当前对象（string1）包含的值与参数对象（string2）包含的值是否相等，若相等则equals（）方法返回true，否则返回false
        String str1=new String("zhangsan");
        String str2=new String("zhangsan");
        String str3="zhangsan";
        String str4="zhangsantest";
        String str5="   liuqi   ";
        out.println("对象等号学习:"+(str1==str2));
        out.println("equals学习:"+str1.equals(str2));
        out.println("字符串等号测试："+(str3==str4));
        //等于0 小于0返回之间的差值 大约0之间的差值
        out.println("compareTo："+str3.compareTo(str4));
        //替换 replace
        out.println(str4.replaceAll("t","Q"));
        //下表取值 subString
        out.println(str3.substring(0,1));
        //contains 返回boolen类型
        out.println(str4.contains("Q"));
        //忽略前导空白和尾部空白 trim
        out.println(str5.trim());

        //StringBuffer速度慢 线程安全  StringBuilder速度快 线程不安全
        StringBuffer stringBuffer=new StringBuffer();
        out.println(stringBuffer.length());
        stringBuffer.insert(0,1);
        out.println(stringBuffer.toString());
        out.println(stringBuffer.length());
        stringBuffer.insert(0,2);
        out.println(stringBuffer.toString());
        stringBuffer.append(3);
        out.println(stringBuffer.toString());
        //反转
        out.println(stringBuffer.reverse());
        out.println(stringBuffer.length());

    }


}
