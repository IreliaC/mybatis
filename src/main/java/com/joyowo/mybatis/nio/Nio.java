package com.joyowo.mybatis.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Author: chenby
 * Date: 2018-01-04
 */
public class Nio {
    @Test
    public void testNio() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        //serverSocketChannel.configureBlocking(false);
        int i = 0;
        while (true) {
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            if (socketChannel == null) {
                i++;
                System.out.println();
            }
        }

    }

    @Test
    public void testNio2() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(9999));
    }
}
