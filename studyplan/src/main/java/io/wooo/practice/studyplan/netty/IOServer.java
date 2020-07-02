package io.wooo.practice.studyplan.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wushuaiping
 * @date 2020/7/2 10:19 上午
 */
public class IOServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        new Thread(() -> {
            while (true){
                try {
                    Socket accept = serverSocket.accept();
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = accept.getInputStream();
                            while ((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
