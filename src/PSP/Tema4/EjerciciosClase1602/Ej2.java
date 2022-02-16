package PSP.Tema4.EjerciciosClase1602;

import java.rmi.AccessException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Ej2 implements Ej1 {
    @Override
    public int suma(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int resta(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int multiplicacion(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public int division(int a, int b) throws RemoteException {
        return a/b;
    }

    public static void main(String[] args) {
        System.out.println("Creando el registro de objetos remotos");
        Registry reg=null;
        try {
            reg= LocateRegistry.createRegistry(5555);
        } catch (RemoteException e) {
            System.out.println("ERROr: ");
            e.printStackTrace();
        }
        System.out.println("Creando el objeto servidor e inscribéndolo en el registro");
        Ej2 serverObject=new Ej2();

        try {
            reg.rebind("Calculadora", (Ej1) UnicastRemoteObject.exportObject(serverObject, 0));
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
