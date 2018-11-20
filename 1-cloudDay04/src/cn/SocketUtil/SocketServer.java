package cn.SocketUtil;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * SocketServer
 * socket�����
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/15</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class SocketServer {

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private ServerSocket serverSocket;


    public SocketServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.serverSocket = serverSocket;
    }




}
