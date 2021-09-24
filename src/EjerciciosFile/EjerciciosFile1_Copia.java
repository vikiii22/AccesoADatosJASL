package EjerciciosFile;

import javax.swing.*;
import java.io.File;

public class EjerciciosFile1_Copia {
    public static void main(String[] args) {
        /*System.out.print("Introduce una ruta: ");
        Scanner sc=new Scanner(System.in);
        String archivo=sc.nextLine();

        File file=new File(archivo);

        //System.out.println(file.getName());
        if (file.isFile() && file.exists()){
            System.out.println("El fichero existe");
        } if (file.isDirectory() && file.exists()){
            System.out.println("El directorio existe");
        }

        if (file.isFile()){
            System.out.println(file.getName()+" es un fichero");
        }else{
            System.out.println("Es un directorio");
        }*/

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
