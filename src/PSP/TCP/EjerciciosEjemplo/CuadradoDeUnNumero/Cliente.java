package PSP.TCP.EjerciciosEjemplo.CuadradoDeUnNumero;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");

            Socket cliente=new Socket();

            System.out.println("Estableciendo conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost", 2112);
            cliente.connect(addr);

            InputStream is=cliente.getInputStream();
            OutputStream os=cliente.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            DataInputStream in=new DataInputStream(is);

            System.out.println("Pensando Número...");

            Scanner sc=new Scanner(System.in);
            System.out.print("Introduce un número: ");
            int numero=sc.nextInt();

            dos.writeInt(numero);
            System.out.println("Número enviado");
            System.out.println(in.readInt() + " Es el cuadrado de " + numero);

            System.out.println("Cerrando el socket cliente");
            cliente.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
