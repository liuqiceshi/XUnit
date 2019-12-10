public class Operators {
    /**
     * @Author: liuqi
     * @Description:
     * @Date: Create in  19/12/10
     * 1、算数运算 + - * / % ++ --
     * 2、关系运算 == !=   >  <   >=  <=
     * 3、逻辑运算符 && || ！
     * 4、三目运算 ?:
     */

    public static void main(String[] args){
        //算数运算 + 三目运算
        int a=20;
        int b=19;
        int d=a+b;
       System.out.println("a+b="+d);
       System.out.println("a/b="+a/b);
       System.out.println("a%b="+a%b);

       int c=b++>=a ? a++:a+b;
        /*
        先运算在赋值；
        1. b先和a作比较，b比a小为假，所以a还是20；
        2. b在自增加1，所以b为20；
        3. 因为三元判断为假，所以c等于自增后的b加a为40；

        */

       System.out.println("a"+a);//20
       System.out.println("b"+b);//20
       System.out.println("c"+c);//40

        /*
        先赋值在运算；
        1.B先自增为20；
        2.三元运算自增后的B等于A，所以c等于20；
        3.因为三元运算为真，所以A自增1为21；
        */
        int c1=++b>=a ? a++:a+b;
        System.out.println("a"+a);//21
        System.out.println("b"+b);//20
        System.out.println("c1"+c1);//20

        int f=3;
        int g=0;
        int h=0;
        System.out.println(g=f++);//3
        System.out.println(f=f++);//4
        System.out.println(f);//4

        //关系运算
        int liuqi1=1;
        int liuqi2=2;
        System.out.println(liuqi1==liuqi2);
        System.out.println(liuqi1!=liuqi2);
        System.out.println(liuqi1 < liuqi2);

        //逻辑运算符 && || ！
        System.out.println(liuqi1==liuqi2 && liuqi1!=liuqi2 );
        System.out.println(liuqi1==liuqi2 || liuqi1!=liuqi2 );

    }


}
