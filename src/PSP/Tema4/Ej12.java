package PSP.Tema4;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Ej12 {
    public static void main(String[] args) {
        System.out.println("Creando el socket datagram");
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String mensaje = new String("Hora");

            InetAddress serverAddr = InetAddress.getByName("localhost");
            DatagramPacket datagram1 = new DatagramPacket(mensaje.getBytes(StandardCharsets.UTF_8), mensaje.getBytes(StandardCharsets.UTF_8).length, serverAddr, 5555);
            datagramSocket.send(datagram1);
            System.out.println("Mensaje enviado");

            byte[] respuesta = new byte[100];
            DatagramPacket datagram2 = new DatagramPacket(respuesta, respuesta.length);
            datagramSocket.receive(datagram2);

            System.out.println("Mensaje recibido: " + new String(respuesta));

            System.out.println("Cerrado el socket");
            datagramSocket.close();


        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}