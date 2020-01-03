package study;

/**
 * @Author liuqi
 * @Date 19/12/27 14:53
 * @Version 1.0
 * @Description:
 */
public class 反射机制 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls=Class.forName("java.util.Date");
        System.out.println(cls);
        System.out.println(Integer.TYPE==int.class);//true
        System.out.println(Integer.class==int.class);//false
    }

}
