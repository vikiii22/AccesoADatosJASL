package PSP.TCP.RepasoExamen.Prueba1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket();
            Socket socket=null;
            InetSocketAddress addr=new InetSocketAddress("localhost", 5554);
            serverSocket.bind(addr);
            while (true) {
                socket = serverSocket.accept();
                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                DataInputStream dis=new DataInputStream(socket.getInputStream());
                String archivos="";

                //dos.writeUTF("Hola desde el servidor");
                File file=new File(".");
                for (File f:file.listFiles()){
                    if (f.isFile()){
                        archivos += f.toString()+"\n";
                    }
                }
                dos.writeUTF(archivos);
                System.out.println(dis.readUTF());
                dos.writeUTF("Selecciona un archivo: ");
                String archivo=dis.readUTF();

                BufferedReader br=new BufferedReader(new FileReader(archivo));
                String contenido="";
                String contenidos="";
                while ((contenido=br.readLine())!=null){
                    contenidos += contenido+"\n";
                }
                dos.writeUTF(contenidos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
