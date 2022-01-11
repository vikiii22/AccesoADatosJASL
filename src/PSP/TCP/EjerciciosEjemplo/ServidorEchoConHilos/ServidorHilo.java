package PSP.TCP.EjerciciosEjemplo.ServidorEchoConHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServidorHilo extends Thread{
    DataInputStream in;
    DataOutputStream os;
    String cadena;

    public ServidorHilo(DataInputStream in, DataOutputStream os, String cadena) {
        this.in = in;
        this.os = os;
        this.cadena = cadena;
    }

    @Override
    public void run() {

    }
}
