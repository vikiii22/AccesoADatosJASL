package PSP.TCP.Ejercicios26012022.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

//Servidor con Hilos
public class Servidor extends Thread {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    static ArrayList<String> listaCompradores;
    static String compradores;
    static int entradas;

    public Servidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Desea comprar una entrada?");

            String comprador = dis.readUTF();
            String nombreCliente="";
            if (comprador.equals("Si") || comprador.equals("si")) {
                dos.writeUTF("Introduce tu nombre y apellidos: ");
                nombreCliente = dis.readUTF();
                dos.writeUTF("Añadido");
                listaCompradores.add(nombreCliente);
            } else {
                //dos.writeUTF(compradores.toString());
                dos.writeInt(listaCompradores.size());
                int quedan=entradas-listaCompradores.size();
                dos.writeInt(quedan);
                for (String s : listaCompradores) {
                    dos.writeUTF(s);
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        Socket socket = null;
        InetSocketAddress addr = new InetSocketAddress("localhost", 5566);
        serverSocket.bind(addr);
        listaCompradores = new ArrayList<>();
        compradores = "";
        entradas=50;
        while (true) {
            try {
                socket = serverSocket.accept();
                new Servidor(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
