package SanchezLopezJoseAntonio_Ejercicio2UD1;

import java.io.File;
import java.util.Scanner;

public class EjerciciosFile3 {
    public static void main(String[] args) {
        System.out.print("Introduce una ruta: ");
        Scanner sc=new Scanner(System.in);
        String directorio=sc.nextLine();

        File file=new File(directorio);

        if (!file.exists()){
            System.out.println("El directorio buscado no existe");
        }else{
            for (File f:file.listFiles()) {
                System.out.println(f.getName());
            }
        }
    }
}
