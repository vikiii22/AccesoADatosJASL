package PSP.TCP.EjerciciosEjemplo.Ejercicio7PruebaLAN;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor7 {

    public static void main(String[] args) {
        //Sockets de cliente y de servidor
        ServerSocket server = null;
        Socket client = null;
        int puerto = 2223;

        System.out.println("Servidor iniciado");
        try {
            //- Crea el socket servidor
            server = new ServerSocket(puerto);

            while(true) {
                //- Espera la petición de un cliente
                client = server.accept();
                //- Lanza un hilo para gestionar el cliente
                System.out.println("Cliente conectado");
                new ServidorGestion(client).start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}