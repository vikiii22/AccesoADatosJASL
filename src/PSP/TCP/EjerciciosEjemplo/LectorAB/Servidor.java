package PSP.TCP.EjerciciosEjemplo.LectorAB;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket server=new ServerSocket();

            InetSocketAddress addr=new InetSocketAddress("localhost", 2112);
            server.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket nuevoSocket=server.accept();
            System.out.println("Conexión recibida");

            InputStream is=nuevoSocket.getInputStream();
            OutputStream os=nuevoSocket.getOutputStream();

            byte[] mensaje=new byte[200];
            is.read(mensaje);

            System.out.println(new String(mensaje));

            nuevoSocket.close();

            System.out.println("Cerrando el socket servidor");
            server.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
