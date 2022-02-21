package PSP.Tema4.Ejercicios21022022.Ejercicio1;

import PSP.Tema4.EjerciciosClase1602.Ej1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class E414 {
    public static void main(String[] args) {
        E412 calc=null;
        try {
            System.out.println("Localizado registro de objetos remotos");
            Registry registry= LocateRegistry.getRegistry("localhost", 5555);
            System.out.println("Obteniendo el stub del objeto remoto");
            calc=(E412) registry.lookup("Calculadora");
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
                System.out.println("5^4 = " + calc.potencia(5, 4));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
