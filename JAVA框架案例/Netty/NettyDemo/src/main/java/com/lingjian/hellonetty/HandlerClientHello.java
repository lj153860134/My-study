package com.lingjian.hellonetty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


import java.nio.ByteBuffer;

/**
 * @description: Netty客户端类
 * @author: Ling Jian
 * @date: 2020-08-03 16:17
 **/
@ChannelHandler.Sharable
public class HandlerClientHello extends SimpleChannelInboundHandler<ByteBuf> {

   
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
    /** 
    * @description: 处理接收到的消息
    * @param: [channelHandlerContext, byteBuffer]
    * @return: void 
    * @author: Ling Jian 
    * @date: 2020/8/3 4:20 下午
    */ 
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuffer) throws Exception {
        System.out.println("接收到的消息：" + byteBuffer.toString(CharsetUtil.UTF_8));

    }
}
