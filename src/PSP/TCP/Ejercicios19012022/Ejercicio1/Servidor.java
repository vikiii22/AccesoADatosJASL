package PSP.TCP.Ejercicios19012022.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static int puerto=2251;
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();

            InetSocketAddress addr = new InetSocketAddress("localhost", puerto);

            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            while (true) {
                Socket nuevo = serverSocket.accept();

                InputStream is = nuevo.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(nuevo.getOutputStream());

                String pregunta = dis.readUTF();

                if (pregunta.contains("?")){
                    if (pregunta.equals("¿Cómo te llamas?")){
                        dos.writeUTF("Me llamo ejercicio 1");
                    }else if (pregunta.equals("¿Cuántas líneas de código tienes?")){
                        dos.writeUTF("Tengo 15 líneas de código");
                    }else{
                        dos.writeUTF("No he entendido la pregunta");
                    }
                }else{
                    dos.writeUTF("No he entendido la pregunta");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
