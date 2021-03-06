package PSP.Tema4.Ejercicios16022022.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor=new ServerSocket();
        Socket socket;
        InetSocketAddress addr=new InetSocketAddress("localhost", 6667);
        servidor.bind(addr);

        Contacto contacto = null;
        List<Contacto> listaContactos=new ArrayList<>();
        int elegido=0;

        String nombre, direccion;
        String nombreEditar="";
        int telefono;
        while (true){
            socket=servidor.accept();
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Elige una opción: \n" +
                    "1. Crear un contacto\n" +
                    "2. Modificar un contacto\n" +
                    "3. Ver contactos\n");
            elegido=dis.readInt();
            switch (elegido){
                case 1:
                    dos.writeUTF("Escribe el nombre del contacto nuevo");
                    nombre=dis.readUTF();

                    dos.writeUTF("Introduce la dirección");
                    direccion=dis.readUTF();

                    dos.writeUTF("Introduce el teléfono");
                    telefono=dis.readInt();

                    contacto=new Contacto(nombre, direccion, telefono);
                    listaContactos.add(contacto);

                    System.out.println("Contacto añadido");

                    int contactosTotales=listaContactos.size();
                    dos.writeInt(contactosTotales);
                    for (Contacto c:listaContactos) {
                        dos.writeUTF(c.toString());
                    }
                    break;
                case 2:
                    dos.writeUTF("Introduce el nombre del contacto a modificar: ");
                    contactosTotales=listaContactos.size();
                    //dos.writeInt(contactosTotales);
                    nombreEditar="";
                    for (Contacto c:listaContactos) {
                        nombreEditar = c.getNombre();
                    }
                    if (dis.readUTF().equals(nombreEditar)) {
                        dos.writeUTF("Introduce el nuevo nombre");
                        contacto.setNombre(dis.readUTF());
                        dos.writeUTF("Introduce la nueva dirección");
                        contacto.setDireccion(dis.readUTF());
                        dos.writeUTF("Introduce el nuevo teléfono");
                        contacto.setTelefono(dis.readInt());
                    }
                case 3:
                    contactosTotales=listaContactos.size();
                    dos.writeInt(contactosTotales);
                    for (Contacto c:listaContactos) {
                        dos.writeUTF(c.toString());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
