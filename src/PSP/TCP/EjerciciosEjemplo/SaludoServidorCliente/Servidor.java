package PSP.TCP.EjerciciosEjemplo.SaludoServidorCliente;

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

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el Bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 7451);
            serverSocket.bind(addr);

            Socket newSocket = null;
            int cliente=1;
            while (cliente <= 3) {

                System.out.println("Aceptando peticiones");

                newSocket = serverSocket.accept();

                System.out.println("Conexión recibida");

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] mensaje = new byte[30];
                is.read(mensaje);
                System.out.println(new String(mensaje));

                System.out.println("Hola cliente nº " + cliente);
                cliente++;
            }
            System.out.println("Cerrando el nuevo Socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
