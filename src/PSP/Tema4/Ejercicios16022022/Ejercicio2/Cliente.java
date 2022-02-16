package PSP.Tema4.Ejercicios16022022.Ejercicio2;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=null;

        socket=new DatagramSocket();
        Scanner sc=new Scanner(System.in);

        InetAddress addr=InetAddress.getByName("localhost");
        System.out.println("Quieres ver la IP?");
        String respuesta=sc.nextLine();

        if (respuesta.equals("S") || respuesta.equals("s") || respuesta.equals("Si") || respuesta.equals("si")){
            byte[] r=respuesta.getBytes();
            DatagramPacket packet=new DatagramPacket(r, r.length, addr, 2541);
            socket.send(packet);

            byte[] entrada=new byte[256];
            packet=new DatagramPacket(entrada, 256);
            socket.receive(packet);

            String ip=new String(entrada);
            System.out.println("IP: " + ip.trim());
        }else{
            socket.close();
        }
    }
}
