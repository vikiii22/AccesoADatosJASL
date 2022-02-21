package PSP.Tema4.Ejercicios21022022.Ejercicio1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface E412 extends Remote {
    public double suma(double a, double b) throws RemoteException;
    public double resta(double a, double b) throws RemoteException;
    public double multiplicacion(double a, double b) throws RemoteException;
    public double division(double a, double b) throws RemoteException;
    public double potencia(double a, double b) throws RemoteException;
}
