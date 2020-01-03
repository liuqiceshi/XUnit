package study.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Author liuqi
 * @Date 20/1/1 12:26
 * @Version 1.0
 * @Description:
 */
public class TcpSever {
    public static  void main(String[] args ) throws IOException {
        String data="hello ";
        ServerSocket server=new ServerSocket(8888);
        System.out.println("服务器已经准备就绪");


    }
}
