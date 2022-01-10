package PSP.TCP.EjerciciosEjemplo.HolaQueTal;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket();

            System.out.print("Introduce un mensaje: ");
            Scanner sc=new Scanner(System.in);
            String mensaje=sc.nextLine();

            System.out.println("Enviando mensaje");

            InetAddress addr=InetAddress.getByName("localhost");
            DatagramPacket datagrama=new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 2112);
            datagramSocket.send(datagrama);
            System.out.println("Mensaje enviado");

            System.out.println("Respuesta: ");
            byte[] mensajeRecibido=new byte[25];
            DatagramPacket datagramPacket=new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(mensajeRecibido));

            datagramSocket.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
