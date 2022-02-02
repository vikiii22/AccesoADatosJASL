package PSP.TCP.RepasoExamen.Prueba3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 6666);
            socket.connect(addr);

            DataInputStream dis=new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
