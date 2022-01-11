package PSP.TCP.EjerciciosEjemplo.ServidorEchoConHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 2112);
            server.bind(addr);
            Socket socket=null;

            System.out.println("Servidor iniciado");
            System.out.println("Aceptando conexiones");
            boolean sigue=true;
            while (sigue){
                socket=server.accept();

                DataInputStream in=new DataInputStream(socket.getInputStream());
                DataOutputStream os=new DataOutputStream(socket.getOutputStream());


                String cadena=in.readUTF();
               /*Esto lo quitaría porque si un cliente pone bye se cerraría el servidor
               *if (cadena.toLowerCase(Locale.ROOT).equals("bye")){
                    sigue=false;
                }*/
                System.out.println(cadena);
                os.writeUTF(cadena);

                ServidorHilo sHilo=new ServidorHilo(in, os, cadena);
                sHilo.start();
            }
            socket.close();
            System.out.println("Terminando el servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
