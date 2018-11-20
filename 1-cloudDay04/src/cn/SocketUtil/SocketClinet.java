package cn.SocketUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * SocketClinet
 * Socket�ͻ���
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/15</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class SocketClinet {
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SocketClinet(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
    }
}
