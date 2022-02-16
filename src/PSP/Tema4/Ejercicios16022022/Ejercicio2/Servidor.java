package PSP.Tema4.Ejercicios16022022.Ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagram = null;

        datagram=new DatagramSocket(2541);
        while (true){
            byte[] entrada=new byte[5];
            DatagramPacket packet=new DatagramPacket(entrada, 5);
            datagram.receive(packet);
            String recibe=new String(entrada);
            if (recibe.equalsIgnoreCase("s")){
                String salida=String.valueOf(packet.getAddress());
                byte[] salida1=salida.getBytes();
                int puerto=packet.getPort();
                InetAddress address=packet.getAddress();
                packet=new DatagramPacket(salida1, salida1.length, address, puerto);
                datagram.send(packet);
            }
        }
    }
}
