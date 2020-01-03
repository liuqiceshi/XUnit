package study.net;

import org.apache.http.client.methods.HttpPost;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author liuqi
 * @Date 19/12/27 15:27
 * @Version 1.0
 * @Description:
 * 网络3要素：  ip 端口 协议（版本、方法、报文格式）
 * URI和URL
 * 2586.11
 *
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        HttpPost httpPost=new HttpPost();
        InetAddress byName = InetAddress.getByName("C02RKG4GFVH5");

        System.out.println(byName.toString());
        //获取主机名称
        System.out.println("HostName:"+byName.getHostName());
        //获取主机地址
        System.out.println("HostAddress:"+byName.getHostAddress());
        //获取本地地址
        System.out.println("getLocalHost:"+InetAddress.getLocalHost());

        InetAddress[] getAllByNames=InetAddress.getAllByName("C02RKG4GFVH5");
        for (InetAddress getAllByNameTest:getAllByNames){

            System.out.println("getAllByNameTest:"+getAllByNameTest);
        }


    }
}
