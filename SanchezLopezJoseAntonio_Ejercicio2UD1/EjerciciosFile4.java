
package SanchezLopezJoseAntonio_Ejercicio2UD1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class EjerciciosFile4 {
    public static void main(String[] args) throws IOException {
        int numeroRandom = (int) (Math.random() * 10);                         //Hago números random para que cada vez que ejecute el programa tenga un nombre diferente
        String nombreArchivo = String.valueOf("Ejercicio" + numeroRandom + ".txt");  //Añado el número random al nombre del fichero
        File directorio = new File("Ejercicio4", nombreArchivo);               //Creo el directorio Ejercicio4 con el fichero creado anteriormente dentro.

        if (!directorio.exists()) {              //si el directorio no existe, me lo crea, si existe y no existe el archivo lo crea
            directorio.getParentFile().mkdir();
            directorio.createNewFile();
            System.out.println(directorio.getName() + " Creado");
        } else {                            //Si el archivo ya existe y se llaman igual, lo elimina
            directorio.delete();
            System.out.println(directorio.getName() + " Eliminado");
        }
    }
}
