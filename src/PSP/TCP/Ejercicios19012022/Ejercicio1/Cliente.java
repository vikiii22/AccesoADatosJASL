package PSP.TCP.Ejercicios19012022.Ejercicio1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static int puerto=2251;
    public static void main(String[] args) {
        try {
            Socket cliente=null;
            while (true){
                cliente=new Socket();

                InetSocketAddress addr=new InetSocketAddress("localhost", puerto);
                cliente.connect(addr);

                InputStream is = cliente.getInputStream();
                OutputStream os = cliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                DataInputStream dis = new DataInputStream(is);

                Scanner sc=new Scanner(System.in);

                System.out.println("Introduce un mensaje");
                String mensaje=sc.nextLine();
                dos.writeUTF(mensaje);
                String devuelta= dis.readUTF();
                System.out.println(devuelta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
