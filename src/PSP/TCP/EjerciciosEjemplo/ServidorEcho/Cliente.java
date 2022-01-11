package PSP.TCP.EjerciciosEjemplo.ServidorEcho;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            boolean sigue = true;
            Socket cliente=null;
            while (sigue) {
                cliente = new Socket();

                //System.out.println("Estableciendo conexión");

                InetSocketAddress addr = new InetSocketAddress("localhost", 2112);
                cliente.connect(addr);

                InputStream is = cliente.getInputStream();
                OutputStream os = cliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                DataInputStream dis = new DataInputStream(is);


                //System.out.println("Enviando mensaje");

                Scanner sc = new Scanner(System.in);
                System.out.print("Introduce una cadena: ");
                String mensaje = sc.nextLine();
                if (mensaje.toLowerCase(Locale.ROOT).contains("bye")) {
                    sigue = false;
                    System.out.println("Cerrando el socket cliente");
                }
                dos.writeUTF(mensaje);
                System.out.println("Mensaje enviado");
                String echo=dis.readUTF();
                System.out.println("Mensaje echo desde el servidor: " + echo);
            }
            cliente.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
