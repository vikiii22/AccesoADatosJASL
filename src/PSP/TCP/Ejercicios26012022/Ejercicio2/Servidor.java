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

public class Servidor extends Thread {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    static ArrayList<String> listaCompradores;
    static String compradores;

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
            if (comprador.equals("Si") || comprador.equals("si")) {
                dos.writeUTF("Introduce tu nombre: ");
                String nombreCliente = dis.readUTF();
                listaCompradores.add(nombreCliente + "\n");
                for (String s : listaCompradores) {
                    compradores += s;
                }
                dos.writeUTF(compradores.toString());
            } else {
                dos.writeUTF(compradores.toString());
            }
            System.out.println(compradores);
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
