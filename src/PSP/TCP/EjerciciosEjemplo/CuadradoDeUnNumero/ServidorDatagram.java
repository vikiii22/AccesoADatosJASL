package PSP.TCP.EjerciciosEjemplo.CuadradoDeUnNumero;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorDatagram {
    public static void main(String[] args) {
        /*try {
            System.out.println("Creando socket servidor");

            InetSocketAddress addr = new InetSocketAddress("localhost", 2112);
            DatagramSocket server = new DatagramSocket(addr);

            System.out.println("Aceptando conexiones");


            System.out.println("Conexión recibida");

            InputStream is = server.get;
            DataInputStream dis = new DataInputStream(is);

            int numero = dis.readInt();
            System.out.println("El cuadrado de " + numero + " es: " + numero * numero);

            nuevoSocket.close();

            System.out.println("Cerrando el socket servidor");
            server.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
