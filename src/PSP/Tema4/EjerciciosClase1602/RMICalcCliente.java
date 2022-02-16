package PSP.Tema4.EjerciciosClase1602;

import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMICalcCliente {
    public static void main(String[] args) {
        Ej1 calc=null;
        try {
            System.out.println("Localizado registro de objetos remotos");
            Registry registry= LocateRegistry.getRegistry("localhost", 5555);
            System.out.println("Obteniendo el stub del objeto remoto");
            calc=(Ej1) registry.lookup("Calculadora");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

        if (calc!=null){
            System.out.println("Realizando operaciones con el objeto remoto");

            try {
                System.out.println("2 + 2 = " + calc.suma(2, 2));
                System.out.println("2 - 2 = " + calc.resta(2, 2));
                System.out.println("2 * 15 = " + calc.multiplicacion(2, 15));
                System.out.println("152 / 4 = " + calc.division(152, 4));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
