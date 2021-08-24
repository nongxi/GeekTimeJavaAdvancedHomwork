package Server;

import serverInitializer.ServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class AppServer {
    private static final int HTTP_PORT = 8080;

    public void run() throws Exception {

        // 创建主从结构的NIO
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 辅助class简化server配置
            ServerBootstrap httpBootstrap = new ServerBootstrap();

            // 配置服务
            httpBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 256)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定请求
            ChannelFuture httpChannel = httpBootstrap.bind(HTTP_PORT).sync();

            // 等待连接关闭
            httpChannel.channel().closeFuture().sync();
        }
        finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new AppServer().run();
    }

}
