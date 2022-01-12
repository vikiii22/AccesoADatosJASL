package PSP.TCP.EjerciciosEjemplo.ServidorDosServicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 9998);
            InetSocketAddress addr2=new InetSocketAddress("localhost", 9999);
            //serverSocket.bind(addr);
            serverSocket.bind(addr2);

            Socket socket=null;
            boolean sigue=true;

            System.out.println("Servidor iniciado");
            System.out.println("Aceptando conexiones");
            while (sigue){
                socket=serverSocket.accept();
                DataOutputStream os=new DataOutputStream(socket.getOutputStream());
                DataInputStream in=new DataInputStream(socket.getInputStream());

                int puerto=in.readInt();
                String mensaje="";

                if (puerto==9998){
                    DateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
                    Date date=new Date();
                    os.writeUTF("La hora actual es: " + dateFormat.format(date));
                }else if (puerto==9999){
                    System.out.println("En el puerto " + puerto);
                    mensaje=in.readUTF();
                    os.writeUTF(mensaje);
                }
                ServidorHilo sHilo=new ServidorHilo(in, os, mensaje);
                sHilo.start();
            }
            socket.close();
            System.out.println("Cerrando servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
