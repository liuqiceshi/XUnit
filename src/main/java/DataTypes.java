/**
 * @Author: liuqi
 * @Description: java基础练习
 * @Date: Create in 22:00 06/12/29
 */
public class DataTypes {
    /**
     * 八大数据类型
     * 1、byte 数据类型是8位  用在大型数组中节约空间，主要代替整数，因为byte变量占用的空间只有int类型的四分之，默认值是0 -128 127
     * 2、short 数据类型是16位， 一个short变量是int型变量所占空间的二分之一；   默认值是0；-32768 32767
     * 3、char 16位Unicode字符  , char数据类型可以储存任何字符 单引号 字符 汉字
     * 4、int  int数据类型是32位    默认值是0
     * 5、long 数据类型是64位  默认值是0L 最好大写
     * 6、double  双精度  64位   默认值是0.0f
     * 7、float 单精度、32位    默认值是0.0f
     * 8、blean（true false）
     *
     * 自动转换  byte,short,char—> int —> long—> float —> double
     */
    public static void main(String[] args){
        //byte
        byte b=  127;
        byte b1=  -128;
        System.out.println(b);
        System.out.println(b1);

        //short
        short s= -32768;
        short s1= 32767;
        System.out.println(s+b1);

        //char
        char c='中';
        char c1='国';
        char c2='我';
        char c3='l';
        char c4='o';
        char c5='v';
        char c6='e';
        System.out.println("c+c1:"+c+c1+c2+c3+c4+c5+c6);

        //int
        int a=1;
        int a1=2;
        System.out.println(a+b);

        //long
        long l = 100000L;
        System.out.println("l:"+l);

        //float
        float f = 234.5f;
        System.out.println("f:"+f);

        //double
        double d = 123.4;
        System.out.println("d:"+d);

        //boolean
        boolean  bool= a>a1;
        System.out.println(bool);

    }


}
