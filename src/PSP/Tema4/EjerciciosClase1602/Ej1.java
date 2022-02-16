package PSP.Tema4.EjerciciosClase1602;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ej1 extends Remote {
    public int suma(int a, int b) throws RemoteException;
    public int resta(int a, int b) throws RemoteException;
    public int multiplicacion(int a, int b) throws RemoteException;
    public int division(int a, int b) throws RemoteException;
}
