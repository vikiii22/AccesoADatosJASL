package PSP.Tema4.Ejercicios21022022.Ejercicio2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Usuario {
    public static void main(String[] args) {
        Mensaje m=null;
        Scanner sc=new Scanner(System.in);

        try {
            Registry registry= LocateRegistry.getRegistry("localhost", 7541);
            m=(Mensaje) registry.lookup("mensajeria");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

        if (m!=null){
            System.out.print("Nombre usuario: ");
            String usuario= sc.nextLine();
            System.out.print("Mensaje: ");
            String mensaje= sc.nextLine();

            try {
                System.out.println("Tu mensaje: " + m.mensaje(usuario, mensaje));
                System.out.println(m.conversacion());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
