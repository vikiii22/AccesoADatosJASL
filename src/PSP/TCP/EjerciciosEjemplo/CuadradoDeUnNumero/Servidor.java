package PSP.TCP.EjerciciosEjemplo.CuadradoDeUnNumero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket server = new ServerSocket();

            InetSocketAddress addr = new InetSocketAddress("localhost", 2112);
            server.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket nuevoSocket = server.accept();
            System.out.println("Conexión recibida");

            InputStream is = nuevoSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream os=new DataOutputStream(nuevoSocket.getOutputStream());

            int numero = dis.readInt();
            System.out.println("El cuadrado de " + numero + " es: " + numero * numero);
            int numeroCuadrado=numero*numero;
            os.writeInt(numeroCuadrado);


            nuevoSocket.close();

            System.out.println("Cerrando el socket servidor");
            server.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
