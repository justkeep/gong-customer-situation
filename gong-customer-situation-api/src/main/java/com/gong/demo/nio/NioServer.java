package com.gong.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NioServer {

    static List<SocketChannel> socketChannelList = new ArrayList<>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(8989));
            //关闭服务端监听阻塞
            serverSocket.configureBlocking(false);
            while (true){
                for (SocketChannel socketClient : socketChannelList) {
                    int read = socketClient.read(byteBuffer);
                    if (read>0){
                        byteBuffer.flip();
                        byte[] bs = new byte[read];
                        byteBuffer.get(bs);
                        String content = new String(bs);
                        System.out.println(content);
                        byteBuffer.flip();
                    }
                }
                SocketChannel socketChannel = serverSocket.accept();
                if (socketChannel!=null){
                    //关闭客户端读时阻塞
                    System.out.println("连接成功");
                    socketChannel.configureBlocking(false);
                    socketChannelList.add(socketChannel);
                    System.out.println("共有链接数"+socketChannelList.size()+"个");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
