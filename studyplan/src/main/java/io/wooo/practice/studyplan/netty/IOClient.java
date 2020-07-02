package io.wooo.practice.studyplan.netty;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author wushuaiping
 * @date 2020/7/2 10:25 上午
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    socket.getOutputStream().write((new Date() + "haha").getBytes());
                    Thread.sleep(1000);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
