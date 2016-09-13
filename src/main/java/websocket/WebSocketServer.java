package websocket;

import com.demo.pojo.ObjectServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê04ÔÂ08ÈÕ added
 */
public class WebSocketServer {

    public void run(int port) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, work)
            .channel(NioServerSocketChannel.class)
            .childHandler(new WebSocketServerHandler());
            /*.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("http-codec", new HttpServerCodec())
                            .addLast("aggregator", new HttpObjectAggregator(65536))
                            .addLast("http-chunked", new ChunkedWriteHandler())
                            .addLast("handler", new WebSocketServerHandler());
                }
            });*/

            Channel ch = b.bind(port).sync().channel();

            System.out.println("Web socket server started at port +:" + port);
            ch.closeFuture().sync();

        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int port = 8088;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new WebSocketServer().run(port);
    }

}
