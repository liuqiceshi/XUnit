package study;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuqi
 * @Description:
 * @Date: Create in  2019/12/17
 * 泛型：
 * 1)存储的时候可以是任意数据类型，取出的时候都是Object类型，此时就得强转
 * 2)约束存储到集合中的元素必须是相同的数据类型；
 * 3）.class文件没用泛型是语法糖
 *
 * 1、泛型类：直接在类/接口上定义的泛型
 * 2、基本使用
 * 3、方法：在方法上声明的泛型
 * 4、通配符、上限、下限：不知道使用什么时候类型的时候实用通配符?,?此时只能接受数据
 * 5、擦除 转换
 *
 */
public class 泛型 {
    public static void main(String[] args){
        List list=new ArrayList();
        list.add(1);//Integer类型
        list.add("liuqi");//String类型
        Object ele=list.get(0);
        Object ele1=list.get(1);
        Integer num=(Integer)ele;
        String num2=(String)ele1;
        for(Object obj:list){
            System.out.println("obj:"+obj);
        }
        System.out.println(ele+" "+ele1);
        List<String> list1=new ArrayList<String>();
        List<Integer> list2=new ArrayList<>();
        list2.add(9);
        doWork(list2);
    }
    private static void doWork(List<?> list){
        System.out.println("输出list："+list);

    }


}
