package PSP.Tema4.Ejercicios16022022.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            while (true){
                Socket cliente=new Socket("localhost", 6667);
                DataInputStream dis=new DataInputStream(cliente.getInputStream());
                DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());

                Scanner sc=new Scanner(System.in);

                int elegido;
                System.out.println(dis.readUTF());
                elegido=sc.nextInt();
                dos.writeInt(elegido);
                switch (elegido){
                    case 1:
                        System.out.println(dis.readUTF());
                        sc.nextLine();
                        dos.writeUTF(sc.nextLine());

                        System.out.println(dis.readUTF());
                        dos.writeUTF(sc.nextLine());

                        System.out.println(dis.readUTF());
                        dos.writeInt(sc.nextInt());
                        int contactos=dis.readInt();
                        for (int i = 0; i < contactos; i++) {
                            System.out.println(dis.readUTF());
                        }
                        break;
                    case 2:
                        System.out.println(dis.readUTF());
                        sc.nextLine();
                        dos.writeUTF(sc.nextLine());
                        System.out.println(dis.readUTF());
                        dos.writeUTF(sc.nextLine());
                        System.out.println(dis.readUTF());
                        dos.writeUTF(sc.nextLine());
                        System.out.println(dis.readUTF());
                        dos.writeInt(sc.nextInt());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
