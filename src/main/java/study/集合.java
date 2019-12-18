package study;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: liuqi
 * @Description:
 * @Date: Create in  2019/12/14
 * 一、list:基于数组的算法、线程不安全、有序可重复、会返回没有元素的集合、在第1次add的时候才会初始化数组
 * 1、ListkdList
 * 2、Vector:线程安全 synchronized 性能不安全
 * 3、ArrayList:线程不安全 性能高   List list=Collections.synchronizedList(new ArrayList(...))变为线程安全的
 * 二、set: 无序不可重复
 *
 * 三、map: key value键值对
 */

public class 集合 {
    public static void main(String[] args){
        ArrayList arrayList=new ArrayList();
        System.out.println("数组大小："+arrayList.size());
        arrayList.add("1");
        arrayList.add("5");

        System.out.println("数组大小："+arrayList.size());
        //方式一：for遍历
        for(int i=0;i<arrayList.size();i++){
            System.out.println("遍历:"+arrayList.get(i));
        }
        //方式二：forEach遍历（低层还是用for循环+索引） 可以操作数组 、集合 、Iterable实例；
        for(Object obj:arrayList){
            System.out.println("遍历:"+obj);
        }
        //方式三：Iterator 遍历 一边迭代一边删除 只能用迭代器对象的remove删除方法 保证了两个线程的同步
        Iterator it=arrayList.iterator();
        while (it.hasNext()){
            Object ele=it.next();
            if ("1".equals(ele)){
                it.remove();
            }
        }
        System.out.println("遍历:"+arrayList);

        //并发修改异常 4001787878



    }
}
