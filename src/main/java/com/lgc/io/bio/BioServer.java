package com.lgc.io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lgc
 * @create 2020-02-11
 **/
public class BioServer {
    /**
     * 传统bio单线程无法并发
     * bio client 连接 server 不发送数据
     * read 函数会阻塞 第二个client 连接不上
     */
    public static void main(String[] args) throws IOException {

        byte[] bs = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9876));
        while (true) {
            System.out.println("等待连接--");
            //accept 专门负责通信
            Socket accept = serverSocket.accept();//阻塞 程序释放cpu资源
            System.out.println("连接成功--");
//            System.out.println("start data--");
//            int read = accept.getInputStream().read(bs);//阻塞
//            System.out.println("end data --" + read);
//            String centent = new String(bs);
//            System.out.println(centent);
            Thread thread = new Thread(new ExecuteSocket(accept));
            thread.start();
        }
    }

    //多线程 子线程阻塞
    static class ExecuteSocket implements Runnable {
        Socket socket;
        byte[] bs = new byte[1024];

        //处理每个连接
        public ExecuteSocket(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.getInputStream().read(bs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String s = new String(bs);
            System.out.println(s);
        }
    }

}
