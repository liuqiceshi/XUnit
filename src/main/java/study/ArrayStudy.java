package study;

public class ArrayStudy {
    /**
     * @Author: liuqi
     * @Description: 数组（1、存储固定大小的同类型元素 2、Java语言使用new操作符来创建数组 3、数组的元素是通过索引访问的。数组索引从 0 开始，所以索引值从 0 到 arrayRefVar.length-1）
     * @Date: Create in  2019/12/13
     */
    public static  void main(String[] args){
        double[] mylist={1.9,2.9,3.4,3.5};
        //遍历数组方式 for-Each循环
        for (double mylistPrint:mylist) {
            System.out.println(mylistPrint);
        }
        //遍历数组方式 for循环
        for(int i=0;i<mylist.length;i++){
            System.out.println(mylist[i]);
        }
        //计算总和
        double total=0;
        for(int i=0;i<mylist.length;i++){
            total+=mylist[i];
            System.out.println("把每次增加的输出："+total);
        }
        System.out.println("总和："+total);
        //查找最大元素
        double max=mylist[0];
        for (int i=1;i<mylist.length;i++){
            if (mylist[i]>max){
                max=mylist[i];
            }
        }
        System.out.println("最大值："+max);

        //数组作为方法的参数
        int[] array={1,2,3,6,4};
        testArray(array);

        //二维数组
        String str[][]=new String[3][4];
        System.out.println("数字的长度："+str.length);
    }
    //数组作为方法的参数
    public static void testArray(int[] array){
        for(int i=0;i<array.length;i++){

            System.out.println("数组作为方法的参数:"+array[i]+" ");
        }

    }

}
