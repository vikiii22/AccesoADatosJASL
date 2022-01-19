package PSP.TCP.Ejercicios19012022.Ejercicio4;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class ClienteArchivos {
    public static void main(String[] args) {
        try {
            boolean sigue=true;
            while (sigue) {
                Socket cliente = new Socket();
                InetSocketAddress addr = new InetSocketAddress("localhost", 5566);
                cliente.connect(addr);

                InputStream is = cliente.getInputStream();
                OutputStream os = cliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                DataInputStream dis = new DataInputStream(is);

                String archivos = dis.readUTF();
                String otro="si";
                while (otro.contains("Si") || otro.contains("si")) {
                    System.out.println("--------------ARCHIVOS DISPONIBLES PARA DESCARGAR-------------");
                    System.out.println(archivos);

                    Scanner sc = new Scanner(System.in);
                    System.out.println();
                    System.out.println("Que archivo quiere descargar?");
                    String archivoElegido = sc.nextLine();
                    dos.writeUTF(archivoElegido);
                    System.out.println(dis.readUTF());
                    System.out.println(dis.readUTF());

                    System.out.print("Quiere descargar otro archivo? ");
                    otro = sc.nextLine();
                }
                sigue=false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
