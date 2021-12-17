package PSP.TCP.EjerciciosEjemplo;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class EmisorDatagram {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket datagram");
            DatagramSocket datagramSocket=new DatagramSocket();
            System.out.println("Enviando mensaje");
            String mensaje="Mensaje extendido desde el programa cliente";
            Scanner sc=new Scanner(System.in);
            String host = sc.nextLine();

            InetAddress addr=InetAddress.getByName(host);
            DatagramPacket datagramPacket=new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);

            datagramSocket.send(datagramPacket);
            System.out.println("Mensaje enviado");
            System.out.println("Cerrando el socket datagrama");
            datagramSocket.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
