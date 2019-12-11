package study;

public class Dog {

    /**
     * @Author: liuqi
     * @Description:
     * @Date: Create in  19/12/09
     * 无参构造方法
     * 有参构造方法
     */

    String name;
    String  colors;
    int age;
    public Dog(){
        System.out.println("我是无参构造方法 " );

    }
    public Dog( String name,String  colors,int age){
        System.out.println("小狗的名字是 : " + name+"  小狗的颜色是："+colors+"  小狗的年龄是 :"+age );
    }

    public void run(){
        System.out.println("小狗会跑" );

    }
    public void jump(){
        System.out.println("小狗会跳" );

    }
    public void eat(){
        System.out.println("小狗爱吃骨头" );

    }


    public static void main(String[] args){
        Dog dog=new Dog();
        dog.run();
        dog.jump();
        dog.eat();
        Dog dog1=new Dog("花花","黑色",1);
        dog1.run();
        dog1.jump();
        dog1.eat();
    }
}
