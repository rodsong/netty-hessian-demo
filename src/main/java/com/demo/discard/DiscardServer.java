package com.demo.discard;

/**
 *
* @author songyanfei
 * @version 1.0
 * @date 2016��03��14�� added
 */

import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Discards any incoming data.
 */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // 多线程事件循环器,第一个经常被叫做‘boss’，用来接收进来的连接。
        // 第二个经常被叫做‘worker’，用来处理已经被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap sbs = new ServerBootstrap(); // (2)
            sbs.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)socket channel
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)option()是提供给NioServerSocketChannel用来接收进来的连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6) childOption()是提供给由父管道ServerChannel接收到的连接

            // Bind and start to accept incoming connections.
            ChannelFuture f = sbs.bind(port).sync(); // (7) 绑定端口然后启动服

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if ( args.length < 0){
            port = Integer.parseInt(args[0]);
        }else{
            port = 8080;
        }
        new DiscardServer(port).run();
    }
}