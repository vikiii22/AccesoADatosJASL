package SanchezLopezJoseAntonio_Ejercicio2UD1;

import java.io.File;
import java.io.IOException;

public class EjerciciosFile0 {
    public static void main(String[] args) throws IOException {
        //Forma 1
        File file=new File("ejercicio0.txt");
        File file2 = new File("D:\\Documents\\ejercicio0.txt");

        file2.createNewFile(); //Esto sería una forma rápida de hacerlo, sin comprobar si existe.

        if (file.exists()){
            System.out.println("Ya existe "+file.getName());
        } if (file.createNewFile()){
            System.out.println(file.getName());
            System.out.println("Creado con éxtio");
        }

        //Forma 2
        System.out.println("----------------FORMA 2--------------");

        File file3=new File("DirEjercicio0","ejercicio0.txt");

        if (!file3.getParentFile().exists()){
            file3.getParentFile().mkdir();
            file3.createNewFile();
            System.out.println("Creado con éxito");
        }else{
            System.out.println("Ya existe");
        }

        //Forma 3

        System.out.println("----------------FORMA 3--------------");

        File ruta=new File("Tercero");
        File file4=new File(ruta, "ejercicio0.txt");

        if (!file4.getParentFile().exists()){
            file4.getParentFile().mkdir();
            file4.createNewFile();
            System.out.println("Creado con éxito");
        }else{
            System.out.println("Ya existe");
        }
    }
}
