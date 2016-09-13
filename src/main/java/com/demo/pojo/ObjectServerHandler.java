package com.demo.pojo;

import com.demo.pojo.impl.Service;
import com.demo.pojo.impl.ServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 描述
 * 怎么样
 * @author songyanfei
 * @version 1.0
 * @date 2016年03月15日 added
 */

public class ObjectServerHandler extends ChannelInboundHandlerAdapter {

    private Service service = new ServiceImpl();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        User user = (User) msg;
        System.out.println(service.doSomething());
        user.setUsername("ooxx");
        ctx.write(user);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
       // ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常信息并关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
