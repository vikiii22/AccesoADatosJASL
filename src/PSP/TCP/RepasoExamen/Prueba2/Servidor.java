package PSP.TCP.RepasoExamen.Prueba2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public Servidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            dos=new DataOutputStream(socket.getOutputStream());
            dis=new DataInputStream(socket.getInputStream());
            dos.writeUTF("hola");
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket();
            Socket socket=null;
            InetSocketAddress addr=new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            while (true) {
                socket = serverSocket.accept();
                new Servidor(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
