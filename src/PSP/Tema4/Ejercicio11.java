package PSP.Tema4;

import java.io.IOException;
import java.net.*;
import java.util.Date;

public class Ejercicio11 {
    public static void main(String[] args) {
        System.out.println("Arrancando servidor de hora.");
        DatagramSocket datagramSocket=null;
        try {
            InetSocketAddress addr=new InetSocketAddress("localhost", 555);
            datagramSocket=new DatagramSocket(addr);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (datagramSocket!=null){
            try {
                System.out.println("Esperando mensaje");

                byte[] buffer=new byte[4];
                DatagramPacket datagrama1=new DatagramPacket(buffer, 4);
                datagramSocket.receive(datagrama1);

                String mensaje=new String(datagrama1.getData());

                InetAddress clienteAddr=datagrama1.getAddress();
                int clientePort=datagrama1.getPort();

                System.out.println("Mensaje recibido: desde " + clienteAddr +
                        ", puerto " + clientePort);
                System.out.println("Contenido del mensaje " + mensaje);

                if (mensaje.equals("hora")){
                    System.out.println("Leyendo respuesta");

                    Date d=new Date(System.currentTimeMillis());
                    byte[] respuesta = d.toString().getBytes();
                    DatagramPacket datagrama2=new DatagramPacket(respuesta, respuesta.length, clienteAddr, clientePort);
                    datagramSocket.send(datagrama2);
                    System.out.println("Mensaje enviado");
                }else{
                    System.out.println("Mensaje recibido no reconocido");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Terminado");
        }
    }
}
