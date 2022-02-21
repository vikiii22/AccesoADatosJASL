package PSP.Tema4.Ejercicios21022022.Ejercicio2;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Mensaje{

    List<String>conversacion=new ArrayList<>();

    @Override
    public String mensaje(String usuario, String mensaje) throws RemoteException {
        String mensajeUsuario=usuario + ": " + mensaje;
        conversacion.add(mensajeUsuario);
        return mensajeUsuario;
    }

    @Override
    public String conversacion() throws RemoteException {
        String c="";
        for (String s:conversacion){
            c+=s+"\n";
        }
        return c;
    }

    public static void main(String[] args) {
        Registry reg=null;
        try {
            reg= LocateRegistry.createRegistry(7541);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Servidor server=new Servidor();

        try {
            reg.bind("mensajeria", (Mensaje) UnicastRemoteObject.exportObject(server, 0));
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
