package PSP.TCP.RepasoExamen.Prueba2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 5555);
            socket.connect(addr);

            DataInputStream dis=new DataInputStream(socket.getInputStream());
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println(dis.readUTF());
                dos.writeUTF("Soy el cliente 2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
