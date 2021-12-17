package PSP.TCP.EjerciciosEjemplo.SaludoServidorCliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");

            Socket clienteSocket = new Socket();

            System.out.println("Estableciendo conexión");

            InetSocketAddress addr = new InetSocketAddress("localhost", 7451);
            clienteSocket.connect(addr);

            InputStream is=clienteSocket.getInputStream();
            OutputStream os=clienteSocket.getOutputStream();

            String mensaje="Soy cliente";
            os.write(mensaje.getBytes(StandardCharsets.UTF_8));
            System.out.println("Mensaje enviado");
            System.out.println("Cerrando el Socket de cliente");
            clienteSocket.close();
            System.out.println("Terminado");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
