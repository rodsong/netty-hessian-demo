package com.demo.pojo;

import com.demo.pojo.impl.Service;
import com.demo.pojo.impl.ServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ����
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016��03��15�� added
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
        //��ӡ�쳣��Ϣ���ر�����
        cause.printStackTrace();
        ctx.close();
    }
}
