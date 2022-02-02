package PSP.TCP.RepasoExamen.Prueba3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;

    public Servidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Iniciando servidor");
            dos.writeUTF("hola desde el servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket();
            Socket socket = null;
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);

            while (true) {
                socket = serverSocket.accept();
                new Servidor(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
