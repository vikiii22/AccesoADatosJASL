package PSP.TCP.Ejercicios19012022.Ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Cliente {
    public static void main(String[] args) {
        try {
            InetSocketAddress addr=new InetSocketAddress("localhost", 5412);
            DatagramSocket datagramSocket=new DatagramSocket(addr);

            System.out.println("Recibiendo mensaje");

            byte[] mensaje=new byte[15];
            DatagramPacket datagramPacket=new DatagramPacket(mensaje, mensaje.length);
            datagramSocket.receive(datagramPacket);

            System.out.println("a");
            System.out.println(new String(mensaje));

            String mensajeEnviado="recibido";
            DatagramPacket datagramPacket1=new DatagramPacket(mensajeEnviado.getBytes(), mensajeEnviado.length(), addr);
            datagramSocket.send(datagramPacket1);

            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
