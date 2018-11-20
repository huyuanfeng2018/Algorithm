package cn.SocketUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * SocketUtil
 * socket编程的工具类
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/15</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class SocketUtil {
    /*服务器端的端口号*/
    public static int Serverport = 4877;
    /*服务区段的ip地址*/
    public static String ip = "172.168.50.120";


    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SocketServer socketServer = null;
                System.out.println("-------------开始创建服务端的套接字，端口为4000-------------");
                try {
                    socketServer = new SocketServer(Serverport);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------套接字创建成功，端口为4000-------------");
                ServerSocket serverSocket = socketServer.getServerSocket();
                while (true) {
                    try {
                        System.out.println("-------------开始等待客户端的呼入-------------");
                        Socket accept = serverSocket.accept();
                        System.out.println("-------------客户端已经呼入了-------------地址为："+accept.getLocalPort());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        String s = reader.readLine();
                        System.out.println(s);
                        accept.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                }
        }).start();


        SocketClinet socketClinet = new SocketClinet(ip, Serverport);
        Socket socket = socketClinet.getSocket();
        BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter os=new PrintWriter(socket.getOutputStream());
        BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Thread.sleep(5000);
        os.write("cececece\n"); os.write("cececece\n");
        Thread.sleep(5000);
        os.flush();
        Thread.sleep(5000);
        os.write("cececece\r\n"); os.write("cececece");


        os.close(); //关闭Socket输出流
        is.close(); //关闭Socket输入流
        socket.close(); //关闭Socket
    }
}
