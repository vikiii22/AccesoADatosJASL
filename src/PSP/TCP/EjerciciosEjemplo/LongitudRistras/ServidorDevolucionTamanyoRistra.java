package PSP.TCP.EjerciciosEjemplo.LongitudRistras;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServidorDevolucionTamanyoRistra {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el Bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 7451);
            serverSocket.bind(addr);

            Socket newSocket = null;
            while (true) {

                System.out.println("Aceptando peticiones");

                newSocket = serverSocket.accept();

                System.out.println("Conexión recibida");

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();

                byte[] mensaje = new byte[30];
                is.read(mensaje);
                System.out.println(new String(mensaje));
                int longitud=mensaje.length;
                String men="Tu mensaje tiene una longitud de: ";
                os.write(String.valueOf(men + longitud).getBytes(StandardCharsets.UTF_8));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
