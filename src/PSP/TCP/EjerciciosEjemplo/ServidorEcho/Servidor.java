package PSP.TCP.EjerciciosEjemplo.ServidorEcho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket server = new ServerSocket();

            InetSocketAddress addr = new InetSocketAddress("localhost", 2112);
            server.bind(addr);

            System.out.println("Aceptando conexiones");

            boolean sigue = true;
            String guardaLista="";
            while (sigue) {
                Socket nuevoSocket = server.accept();

                //System.out.println("Conexión recibida");

                InputStream is = nuevoSocket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(nuevoSocket.getOutputStream());

                String cadena = dis.readUTF();
                dos.writeUTF(cadena);

                if (cadena.toLowerCase(Locale.ROOT).contains("bye")) {
                    sigue = false;
                    nuevoSocket.close();
                }
                //System.out.println(cadena);
                guardaLista+=cadena+"\n";
            }
            System.out.println("Este cliente ha enviado las siguientes cadenas: " + "\n"+guardaLista);
            System.out.println("Cerrando el socket servidor");
            server.close();
            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
