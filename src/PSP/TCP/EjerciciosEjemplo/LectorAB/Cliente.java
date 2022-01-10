package PSP.TCP.EjerciciosEjemplo.LectorAB;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");

            Socket cliente=new Socket();

            System.out.println("Estableciendo conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost", 2112);
            cliente.connect(addr);

            InputStream is=cliente.getInputStream();
            OutputStream os=cliente.getOutputStream();

            System.out.println("Enviando archivo");

            BufferedReader br=new BufferedReader(new FileReader("textFile.txt"));
            String texto="";
            String mensaje="";
            while ((texto=br.readLine())!=null){
                mensaje+=texto+"\n";
            }

            os.write(mensaje.getBytes(StandardCharsets.UTF_8));
            System.out.println("Mensaje enviado");
            System.out.println("Cerrando el socket cliente");
            cliente.close();
            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
