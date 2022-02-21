package PSP.Tema4.Ejercicios21022022.Ejercicio2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensaje extends Remote {
    public String mensaje(String usuario, String mensaje) throws RemoteException;
    public String conversacion() throws RemoteException;
}
