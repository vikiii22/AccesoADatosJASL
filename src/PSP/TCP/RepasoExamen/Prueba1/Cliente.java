package PSP.TCP.RepasoExamen.Prueba1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 5554);

            socket.connect(addr);

            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            DataInputStream dis=new DataInputStream(socket.getInputStream());

            System.out.println(dis.readUTF());
            System.out.println("Mensaje recibido");
            dos.writeUTF("Hola desde el cliente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
