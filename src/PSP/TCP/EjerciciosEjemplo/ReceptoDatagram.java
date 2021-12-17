package PSP.TCP.EjerciciosEjemplo;

import java.io.IOException;
import java.net.*;

public class ReceptoDatagram {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket datagram");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            DatagramSocket datagramSocket=new DatagramSocket(addr);
            System.out.println("Recibiendo mensaje");

            byte[] mensaje=new byte[40];
            DatagramPacket datagramPacket=new DatagramPacket(mensaje, 40);
            datagramSocket.receive(datagramPacket);
            System.out.println("Mensaje recibido: " + new String(mensaje));
            System.out.println("Enviando mensaje");

            InetAddress addr2=InetAddress.getByName("localhost");
            DatagramPacket datagramPacket1=new DatagramPacket(mensaje, mensaje.length,  addr2, 5556);
            datagramSocket.send(datagramPacket1);

            System.out.println("Mensaje enviado");
            System.out.println("Cerrando el socket datagram");
            datagramSocket.close();
            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
