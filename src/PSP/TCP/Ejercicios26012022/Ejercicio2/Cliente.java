package PSP.TCP.Ejercicios26012022.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        while (true){
            Socket cliente=new Socket();
            InetSocketAddress addr=new InetSocketAddress("localhost", 5566);
            try {
                cliente.connect(addr);
                DataInputStream dis=new DataInputStream(cliente.getInputStream());
                DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());

                System.out.println(dis.readUTF());
                Scanner sc=new Scanner(System.in);
                String respuesta=sc.nextLine();
                dos.writeUTF(respuesta);
                if (respuesta.equals("no") || respuesta.equals("No")){
                    System.out.println("Desea ver la lista de compradores?");
                    String verLista= sc.nextLine();
                    if (verLista.toLowerCase().equals("si")){
                        int veces=dis.readInt();
                        int quedan= dis.readInt();
                        for (int i = 0; i < veces; i++) {
                            System.out.println(dis.readUTF());
                        }
                        System.out.println("Han comprado entradas " + veces + " personas");
                        System.out.println("Quedan " + quedan + " disponibles");
                        cliente.close();
                        break;
                    }else{
                        cliente.close();
                        break;
                    }
                }else {
                    System.out.println(dis.readUTF());
                    String nombre = sc.nextLine();
                    dos.writeUTF(nombre);
                    System.out.println(dis.readUTF());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
