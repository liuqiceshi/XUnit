package study;

import java.util.*;

/**
 * @Author: liuqi
 * @Description:
 * @Date: Create in  2019/12/14
 * 一、list:基于数组的算法、线程不安全、有序可重复、会返回没有元素的集合、在第1次add的时候才会初始化数组
 * 1、ListkdList
 * 2、Vector:线程安全 synchronized 性能不安全
 * 3、ArrayList:线程不安全 性能高   List list=Collections.synchronizedList(new ArrayList(...))变为线程安全的
 * 二、set:
 * 1、不允许元素重复 2、不会记录元素先后添加顺序
 * add
 * clear
 * contains
 *
 * 三、map: key value键值对
 * 遍历 for-each  Iterator
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
        //set
        Set<String> set1=new HashSet<>();
        set1.add("zhangsan");
        set1.add("zhangsan");
        set1.add("zhangsan");
        set1.add("1");
        set1.add("lisi");
        System.out.println("set1的长度："+set1.size());
        for(String element:set1){
            System.out.println("set1值"+element);
        }
       // set1.clear();

        System.out.println("set1里边包含zhangsan："+set1.contains("zhangsan"));
        Set<String> set2=new HashSet<>();
        set2.add("zhangsan");
        set2.add("lisi");
        System.out.println("set1对象和set2对象是否相等："+set1.equals(set2));
        System.out.println("set1的hashCode值:"+set1.hashCode());
        System.out.println("set2的hashCode值:"+set2.hashCode());

        //map
        Map<Integer,String> map =new HashMap();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhangsan");
        //map 遍历map中的键值 方法一
        Set<Integer> keys=map.keySet();
        for(Integer key:keys){
            System.out.println("输出map的键值"+key+":"+map.get(key));
        }
        //遍历map中的值
        for (String valueMap:map.values()){
            System.out.println("valueMap的值:"+valueMap);
        }
        //lamba表达式输出key和value的值
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        //通过entrySet获取key和value的值
        Set<Map.Entry<Integer, String>> entries=map.entrySet();
        for(Map.Entry<Integer,String> entry:entries){
            System.out.println("key值："+entry.getKey()+"value值："+entry.getValue());

        }


        System.out.println("map:"+map);
        System.out.println("map中是否包含zhangsan:"+map.containsValue("zhangsan"));
        System.out.println("找出2的内容:"+map.get(2));
        map.remove(3);
        for (int i=0;i<map.size();i++){
            System.out.println("删除3中后map的内容："+map.get(i));
        }
        //TreeMap 排序
        Map<String,Object> treeMap=new TreeMap<>();
        treeMap.put("C","value");
        treeMap.put("D","value");
        treeMap.put("B","value");
        treeMap.put("A","value");
        System.out.println("treeMap:"+treeMap);

        //计算字符串出现的次数
        String str="sjdkfsfhjsjiwrhacrihksfksjdfkdkdddd";
        char[] arr=str.toCharArray();
        //按照自然顺序排序
        Map<Character,Integer> map1=new TreeMap<>();
        //按照先后添加的顺序
        Map<Character,Integer> map2=new LinkedHashMap<>();
        //循环得到每个字符
        for(char ch:arr){
            //判断当前字符是否在map已存在
            if (map1.containsKey(ch)){
                Integer old=map1.get(ch);
                //已存在进行在老的value上加1
                map1.put(ch,old+1);
            }else {
                //不存在的话设置value为1
                map1.put(ch,1);

            }

        }
        System.out.println("字符串出现的个数"+map1);

        //set map list 混用

        //集合和数组的转换


    }
}
