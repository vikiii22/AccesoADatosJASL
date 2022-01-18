package PSP.TCP.EjerciciosEjemplo.Ejercicio7PruebaLAN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServidorGestion extends Thread {

    private Socket socket;
    private DataInputStream entrada = null;
    private DataOutputStream salida = null;
    private String cadena;

    public ServidorGestion(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //- Obtiene el flujo de entrada
            entrada = new DataInputStream(socket.getInputStream());
            //- Ontiene el flujo de salida
            salida = new DataOutputStream(socket.getOutputStream());

            while (true) {
                cadena = entrada.readUTF();
                salida.writeUTF(cadena);
                if (cadena.compareTo("Bye") == 0) { break; }
            }

            //- Cierra el flujo de salida
            salida.close();
            //- Cierra el flujo de entrada
            entrada.close();
            //- Cierra el socket del cliente
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}