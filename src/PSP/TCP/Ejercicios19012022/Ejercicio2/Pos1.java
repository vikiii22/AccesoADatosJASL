package PSP.TCP.Ejercicios19012022.Ejercicio2;

import java.io.IOException;
import java.net.*;

public class Pos1 {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            String mensajeEnv="token";
            byte[] mensaje=mensajeEnv.getBytes();
            InetAddress addr=InetAddress.getByName("localhost");
            int puerto=5512;

            DatagramPacket datagramPacket=new DatagramPacket(mensaje, mensaje.length, addr, puerto);

            datagramSocket.send(datagramPacket);

            byte[] respuesta=new byte[15];
            DatagramPacket respuestas=new DatagramPacket(respuesta, respuesta.length);
            datagramSocket.receive(respuestas);
            String recibido=new String(respuestas.getData());

            System.out.println("Respuesta " + recibido.trim());

            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
