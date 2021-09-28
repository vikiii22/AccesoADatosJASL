package EjerciciosGestionFicheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        File file=new File("textFile.txt");
        FileWriter fw=new FileWriter(file);
        fw.write("Ejemplo");
        fw.write("\nPrueba");
        fw.close();
    }
}
