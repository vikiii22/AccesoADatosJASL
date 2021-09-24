package EjerciciosFile;

import javax.swing.*;
import java.io.File;

public class EjerciciosFile1 {
    public static void main(String[] args) {
        String archivo2 = JOptionPane.showInputDialog("Introduce una ruta");

        File file1 = new File(archivo2);

        if (file1.exists() && file1.isFile()) {
            JOptionPane.showMessageDialog(null, file1.getName() + " es un fichero");
        }
        if (file1.exists() && file1.isDirectory()) {
            JOptionPane.showMessageDialog(null, file1.getName() + " es un directorio");
            JOptionPane.showMessageDialog(null, file1.listFiles());
        }
    }
}
