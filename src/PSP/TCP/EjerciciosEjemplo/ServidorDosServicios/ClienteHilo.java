package PSP.TCP.EjerciciosEjemplo.ServidorDosServicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClienteHilo extends Thread{
    DataOutputStream os;
    DataInputStream in;
    String mensaje;

    public ClienteHilo(DataOutputStream os, DataInputStream in, String mensaje) {
        this.os = os;
        this.in = in;
        this.mensaje=mensaje;
    }

    @Override
    public void run() {

    }
}
