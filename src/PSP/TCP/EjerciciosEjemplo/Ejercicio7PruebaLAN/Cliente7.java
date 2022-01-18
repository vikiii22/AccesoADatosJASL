package PSP.TCP.EjerciciosEjemplo.Ejercicio7PruebaLAN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


class Cliente7Thread extends Thread{
    private Socket client;

    public Cliente7Thread(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        String cadena = "";
        Scanner sc = new Scanner(System.in);

        try {
            //- Obtiene los flujos de entrada/salida
            entrada = new DataInputStream (client.getInputStream());
            salida = new DataOutputStream (client.getOutputStream());

            while (cadena.compareTo("Bye") != 0) {
                System.out.print("Introduce una cadena: ");
                cadena = sc.nextLine();
                salida.writeUTF(cadena);
                System.out.println(entrada.readUTF());
            }

            salida.close();
            entrada.close();
            client.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
public class Cliente7 {

    public static void main(String[] args) {
        int puerto = 2223;

        try {
            //se ejecutan dos clientes a la vez
            new Cliente7Thread(new Socket("192.168.103.116", puerto)).start();
            //new Cliente7Thread(new Socket("192.168.101.219", puerto)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}