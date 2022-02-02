package PSP.TCP.RepasoExamen.Prueba1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            while (true) {
                Socket socket=new Socket();
                InetSocketAddress addr=new InetSocketAddress("localhost", 5554);
                Scanner sc=new Scanner(System.in);

                socket.connect(addr);

                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                DataInputStream dis=new DataInputStream(socket.getInputStream());

                String archivos=dis.readUTF();
                System.out.println(archivos);
                dos.writeUTF("Hola desde el cliente");
                System.out.println(dis.readUTF());
                String archivo=sc.nextLine();
                dos.writeUTF(archivo);
                String archivosRecibidos=dis.readUTF();
                System.out.println("PREPARANDO DESCARGA");
                Thread.sleep(1500);
                System.out.println("CONTENIDO DESCARGADO");
                System.out.println(archivosRecibidos);
                Thread.sleep(1500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
