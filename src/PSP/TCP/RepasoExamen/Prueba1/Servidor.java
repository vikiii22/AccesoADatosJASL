package PSP.TCP.RepasoExamen.Prueba1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket();
            Socket socket=null;
            InetSocketAddress addr=new InetSocketAddress("localhost", 5554);
            serverSocket.bind(addr);
            int cliente=1;
            while (cliente <= 3) {
                cliente++;
                socket = serverSocket.accept();
                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                DataInputStream dis=new DataInputStream(socket.getInputStream());

                dos.writeUTF("Hola desde el servidor");
                System.out.println(dis.readUTF());
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
