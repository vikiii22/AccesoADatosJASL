package PSP.TCP.Ejercicios26012022.Ejercicio1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorArchivos {
    public static void main(String[] args) {
        try {
            ServerSocket socket=new ServerSocket();
            String archivo="";
            File archivos=new File(".");
            for (File f:archivos.listFiles()){
                //En mi caso respecto al ejercicio 4, cambiando esto ya podría obtener todos los ficheros menos el directorio
                if (f.isFile() /*&& f.getName().endsWith(".txt")*/){
                    archivo+=f.getName()+"\n";
                }
            }
            InetSocketAddress addr=new InetSocketAddress("localhost", 5566);
            socket.bind(addr);
            Socket nuevoSocket=null;
            while (true){
                nuevoSocket=socket.accept();

                InputStream is = nuevoSocket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(nuevoSocket.getOutputStream());

                dos.writeUTF(archivo);

                String elegido=dis.readUTF();

                if (archivo.contains(elegido)){
                    System.out.println("Archivo elegido para descargar: " + elegido);
                    dos.writeUTF("Preparando tu descarga");
                    Thread.sleep(2000);
                    dos.writeUTF("Transferencia completada");
                }else{
                    dos.writeUTF(elegido + " no existe");
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
