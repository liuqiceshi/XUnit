package study.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author liuqi
 * @Date 20/1/1 12:31
 * @Version 1.0
 * @Description:
 */
public class EnCoding {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //System.out.println(System.getProperties("file.encoding"));
        String name="刘琦liuqi67";
        System.out.println("name:"+name);
        //使用UTF-8编码
        String encode= URLEncoder.encode(name,"UTF-8");
        System.out.println("encode:"+encode);
        //使用UTF-8界面
        String decode= URLDecoder.decode(name,"UTF-8") ;
        System.out.println("decode:"+decode);


    }
}
