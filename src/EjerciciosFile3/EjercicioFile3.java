package EjerciciosFile3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioFile3 {
    public static void main(String[] args) throws IOException {
        System.out.println("¿Que quieres hacer?\n" +
                "1. Información archivo/directorio\n" +
                "2. Crear directorio\n" +
                "3. Crear fichero\n" +
                "4. Comparar\n" +
                "5. Eliminar");

        Scanner sc = new Scanner(System.in);
        System.out.print("Elige una opción del menú: ");
        int elegido = sc.nextInt();

        System.out.print("Introduce una ruta: ");
        sc.nextLine();
        String rutaAnyadida = sc.nextLine();
        File ruta = new File(rutaAnyadida);


        switch (elegido) {
            case 1:
                System.out.println(ruta.getName());
                System.out.println(ruta.getPath());
                System.out.println(ruta.getAbsolutePath());
                System.out.println(ruta.length());
                if (ruta.isFile()) {
                    System.out.println("Es un fichero");
                } else {
                    System.out.println("Es un directorio");
                }
                System.out.println(ruta.getParent());
                if (ruta.canRead() != true) {
                    System.out.println("No se puede leer");
                } else {
                    System.out.println("Se puede leer");
                }
                if (ruta.canWrite() != true) {
                    System.out.println("No se puede escribir");
                } else {
                    System.out.println("Se puede escribir");
                }
                break;
            case 2:
                ruta.mkdir();
                break;
            case 3:
                ruta.createNewFile();
                break;
            case 4:
                //No me ha dado tiempo
                break;
            case 5:
                System.out.println("Está seguro de que desea elimnar " + ruta.getName() + "?");
                String seguro = sc.nextLine();
                if (seguro.equals("Si") || seguro.equals("si")) {
                    ruta.delete();
                } else {
                    break;
                }
                break;
            default:
                System.out.println("Error");
        }
    }
}
