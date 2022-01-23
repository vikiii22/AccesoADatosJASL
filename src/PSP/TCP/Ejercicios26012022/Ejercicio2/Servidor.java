package PSP.TCP.Ejercicios26012022.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Servidor extends Thread{
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    ArrayList<String> listaCompradores;

    public Servidor(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            dis=new DataInputStream(socket.getInputStream());
            dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Desea comprar una entrada?");
            listaCompradores=new ArrayList<>();
            String comprador=dis.readUTF();
            if (comprador.equals("Si") || comprador.equals("si")){
                dos.writeUTF("Introduce tu nombre: ");
                String nombreCliente=dis.readUTF();
                listaCompradores.add(nombreCliente);
                for (String s:listaCompradores){
                    String compradores="";
                    compradores+=s+"\n";
                    dos.writeUTF(compradores);
                }
            }else{
                for (String s:listaCompradores){
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        Socket socket=null;
        InetSocketAddress addr=new InetSocketAddress("localhost", 5566);
        serverSocket.bind(addr);
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
