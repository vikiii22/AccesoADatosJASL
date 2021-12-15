package PSP.TCP.EjerciciosEjemplo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketStream {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el Bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);

            int cliente = 1;
            Socket newSocket=null;
            while (cliente <= 3) {

                System.out.println("Aceptando peticiones");


                System.out.println("Conexión recibida, cliente: " + cliente);

                newSocket=serverSocket.accept();

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] mensaje = new byte[60];
                is.read(mensaje);

                System.out.println("Mensaje recibido " + new String(mensaje));
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
