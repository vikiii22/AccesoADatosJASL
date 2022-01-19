package PSP.TCP.Ejercicios19012022.Ejercicio2;

import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket datagram");

            DatagramSocket datagramSocket=new DatagramSocket();

            String mensaje="token";
            InetAddress addr=InetAddress.getByName("localhost");
            DatagramPacket datagramPacket=new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5412);
            datagramSocket.send(datagramPacket);

            System.out.println("Token enviado");

            byte[] mensajeRecibido=new byte[15];
            DatagramPacket datagramPacket1=new DatagramPacket(mensajeRecibido, 15);
            datagramSocket.receive(datagramPacket1);
            System.out.println(new String(mensajeRecibido));
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
