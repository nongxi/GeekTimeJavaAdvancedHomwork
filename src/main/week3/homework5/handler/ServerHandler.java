package handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import timeservice.TimeService;

public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    TimeService ts=new TimeService();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        ByteBuf content = Unpooled.copiedBuffer("  Hello,Worlds!"+ts, CharsetUtil.UTF_8);
        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readByte());
        ctx.write(response);
        ctx.flush();
    }

}