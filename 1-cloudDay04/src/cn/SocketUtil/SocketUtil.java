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
 * socket��̵Ĺ�����
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/15</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class SocketUtil {
    /*�������˵Ķ˿ں�*/
    public static int Serverport = 4877;
    /*�������ε�ip��ַ*/
    public static String ip = "172.168.50.120";


    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SocketServer socketServer = null;
                System.out.println("-------------��ʼ��������˵��׽��֣��˿�Ϊ4000-------------");
                try {
                    socketServer = new SocketServer(Serverport);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------�׽��ִ����ɹ����˿�Ϊ4000-------------");
                ServerSocket serverSocket = socketServer.getServerSocket();
                while (true) {
                    try {
                        System.out.println("-------------��ʼ�ȴ��ͻ��˵ĺ���-------------");
                        Socket accept = serverSocket.accept();
                        System.out.println("-------------�ͻ����Ѿ�������-------------��ַΪ��"+accept.getLocalPort());
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


        os.close(); //�ر�Socket�����
        is.close(); //�ر�Socket������
        socket.close(); //�ر�Socket
    }
}
