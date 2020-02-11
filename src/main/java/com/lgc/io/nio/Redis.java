package com.lgc.io.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lgc
 * @create 2020-02-11
 **/
public class Redis {
    /**
     * 单线程处理nio 实现多线程
     * @param args
     */
    public static void main(String[] args) {
        List<SocketChannel> list = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8999));
            ssc.configureBlocking(false);//非阻塞
            while (true) {
//                Selector selector = Selector.open();
                SocketChannel socketChannel = ssc.accept();
                if (socketChannel == null) {
                    Thread.sleep(1000);
                    System.out.println("没人连接");
                    for (SocketChannel channel : list) {
                        int k = channel.read(byteBuffer);
                        System.out.println(k);
                        if (k != 0) {
                            System.out.println("xxx");
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                        }
                    }
                } else {
                    socketChannel.configureBlocking(false);
                    list.add(socketChannel);
                    // 循环套接字获取数据
                    for (SocketChannel channel : list) {
                        int k = channel.read(byteBuffer);
                        System.out.println(k + "-====conn====");
                        if (k != 0) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
