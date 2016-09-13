package com.demo.pojo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê03ÔÂ15ÈÕ added
 */
public class ObjectClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
     /*   User user = new User();
        user.setId(1L);
        user.setUsername("netty");
        ctx.write(user);
        ctx.flush();*/
        System.out.println("channel active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        User user = (User) msg;
        System.out.println(user.toString());
        //ctx.write(user);
       // ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        // ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}