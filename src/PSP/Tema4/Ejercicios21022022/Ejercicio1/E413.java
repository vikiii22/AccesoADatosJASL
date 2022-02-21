package PSP.Tema4.Ejercicios21022022.Ejercicio1;

import PSP.Tema4.EjerciciosClase1602.Ej1;
import PSP.Tema4.EjerciciosClase1602.Ej2;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class E413 implements E412{

    @Override
    public double suma(double a, double b) throws RemoteException {
        return a+b;
    }

    @Override
    public double resta(double a, double b) throws RemoteException {
        return a-b;
    }

    @Override
    public double multiplicacion(double a, double b) throws RemoteException {
        return a*b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        return a/b;
    }

    @Override
    public double potencia(double a, double b) throws RemoteException {
        double c=a;
        for (int i = 1; i < b; i++) {
            a=a*c;
        }
        return a;
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
        E413 serverObject=new E413();

        try {
            reg.rebind("Calculadora", (E412) UnicastRemoteObject.exportObject(serverObject, 0));
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
