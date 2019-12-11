public class Circle {
    /**
     * @Author: liuqi
     * @Description:
     * @Date: Create in 2019/12/10
     * while
     * do while
     * for
     * switch
     * continue
     * break
     * if语句
     */
    public static void main(String[] args){
        int a=0;
        int b=0;
        while(a<5){
           ++a;
          //System.out.println(a);
        }

        do {
            ++b;
           // System.out.println(b);

        }while (b<5);

        //for循环
        char[] aa={'a','b','c','d','e'};
        for(int i=0;i<aa.length;i++){
            System.out.println("第"+i+"个是"+aa[i]);
        }
        //增强for循环
        String[] names={"zhangsan","lisi","wangwu","zhaoliu","liuqi"};
        for(String name:names){
            if(name=="lisi"){
                //跳过lisi继续执行
                continue;
            }else if(name=="zhaoliu"){
                //到zhaoliu停止循环
                break;
            }
            System.out.println("姓名："+name);

        }

        int x=30;
        if (x==30){
            System.out.println("value of x is 30");
        }else  if(x==40){
            System.out.println("value of x is 40");
        }else if(x==50){
            System.out.println("value of x is 50");
        }

        //switch
        String colors="red";
        switch(colors){
            case "red":
                System.out.println("我是红色");
            case "yellow":
                System.out.println("我是黄色");
            case "blue":
                System.out.println("我是蓝色");
                break;
            case "black":
                System.out.println("我是黑色");
            default:
                System.out.println("我是默认颜色粉色");
        }



    }
}
