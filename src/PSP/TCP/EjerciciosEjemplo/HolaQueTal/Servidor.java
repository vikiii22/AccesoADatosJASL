package PSP.TCP.EjerciciosEjemplo.HolaQueTal;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Servidor {
    public static void main(String[] args) {
        try {
            InetSocketAddress addr=new InetSocketAddress("localhost", 2112);
            DatagramSocket datagramSocket=new DatagramSocket(addr);

            System.out.println("Recibiendo mensaje");

            byte[] mensaje=new byte[25];
            DatagramPacket datagramPacket=new DatagramPacket(mensaje, 25);
            datagramSocket.receive(datagramPacket);

            String mensajeRecibido=new String(datagramPacket.getData());
            System.out.println(mensajeRecibido);

            String mensajeDeVuelta="";
            if(mensajeRecibido.toLowerCase(Locale.ROOT).contains("hola")){
                mensajeDeVuelta+="¿Que tal? ";
            }

            DatagramPacket datagrama2=new DatagramPacket(mensajeDeVuelta.getBytes(StandardCharsets.UTF_8), mensajeDeVuelta.length(),
                    datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(datagrama2);

            System.out.println("Respuesta enviada");
            datagramSocket.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
