package PSP.TCP.EjerciciosEjemplo.ServidorEchoConHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            boolean sigue = true;
            Socket socket=null;
            while (sigue) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Introduce una cadena: ");
                String cadena = sc.nextLine();
                socket = new Socket();
                InetSocketAddress addr = new InetSocketAddress("localhost", 2112);
                socket.connect(addr);

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());

                if (cadena.toLowerCase(Locale.ROOT).equals("bye")) {
                    sigue = false;
                }
                os.writeUTF(cadena);
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                ClienteHilo cHilo = new ClienteHilo(os, in, mensaje);
                cHilo.start();
            }
            socket.close();
            System.out.println("Terminando ejecución");
            //cHilo.join();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
