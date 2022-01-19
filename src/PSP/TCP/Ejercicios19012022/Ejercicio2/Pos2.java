package PSP.TCP.Ejercicios19012022.Ejercicio2;

import java.io.IOException;
import java.net.*;

public class Pos2 {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket(5512);
            while (true){
                byte[] mensaje=new byte[15];
                DatagramPacket datagramPacket=new DatagramPacket(mensaje, mensaje.length);
                datagramSocket.receive(datagramPacket);
                String mensajeRecibido=new String(mensaje);
                System.out.println(mensajeRecibido.trim());

                String mensajeEnv="recibido";
                byte[] mensajeAEnviar=mensajeEnv.getBytes();
                InetAddress addr=datagramPacket.getAddress();
                int puerto=datagramPacket.getPort();
                DatagramPacket respuesta=new DatagramPacket(mensajeAEnviar, mensajeAEnviar.length, addr, puerto);

                datagramSocket.send(respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
