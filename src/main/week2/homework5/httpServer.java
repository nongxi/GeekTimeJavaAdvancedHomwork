package homework5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;

public class httpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8801);
        while(true){
            try{
                Socket socket=serverSocket.accept();
                service(socket);
            }catch(ServerException e){
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket){
        try{
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1/1 200 OK");
            printWriter.println("Content-type:text/html;charset-utf-8");
            String body="Hello,homework5!";
            printWriter.println("Contebt-type:"+body.getBytes().length);
            printWriter.println();
            printWriter.println(body);
            printWriter.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
