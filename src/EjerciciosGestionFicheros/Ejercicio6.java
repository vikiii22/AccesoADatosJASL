package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents\\2DAM\\AccesoADatos\\ejemplo.txt";
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.println((char) i);
        }
        fileReader.close();
    }
}
