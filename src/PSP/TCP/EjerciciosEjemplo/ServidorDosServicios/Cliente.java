package PSP.TCP.EjerciciosEjemplo.ServidorDosServicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            DataInputStream in;
            DataOutputStream os;

            Socket socket = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("Por que puerto quieres entrar: \n" +
                    "1: Te diré la hora: \n" +
                    "2: Funcionaré como el eco: ");
            int elegido = sc.nextInt();
            int puerto = 0;
            if (elegido == 1) {
                puerto = 9998;
            } else if (elegido == 2) {
                puerto = 9999;
            }

            boolean sigue=true;
            while (sigue) {
                socket = new Socket();
                InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
                socket.connect(addr);

                os=new DataOutputStream(socket.getOutputStream());
                os.writeInt(puerto);
                System.out.println("Puerto seleccionado " + puerto);
                if (puerto==9998){
                    in=new DataInputStream(socket.getInputStream());
                    //String salida=in.readUTF();
                    //System.out.println(salida);
                    sigue=false;
                }
                System.out.println("Escribe una cadena: ");
                String mensaje=sc.nextLine();
                os.writeUTF(mensaje);

                in=new DataInputStream(socket.getInputStream());
                String salida=in.readUTF();
                System.out.println(salida);

                ClienteHilo cHilo=new ClienteHilo(os, in, mensaje);
                cHilo.start();
            }
            socket.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
