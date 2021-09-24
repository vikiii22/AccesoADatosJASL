package EjerciciosFile2;

import java.io.File;
import java.util.Scanner;

public class ClaseMain {
    public static void main(String[] args) throws UtilityFileException {
        FolderComparator f1 = new FolderComparator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una ruta: ");
        File ruta1 = new File(sc.nextLine());
        System.out.print("Ingresa otra ruta: ");
        File ruta2 = new File(sc.nextLine());

        f1.setFolders(ruta1, ruta2);
        f1.getFolderA(ruta1);
        f1.getFolderB(ruta2);

        f1.compare(ruta1, ruta2);
    }
}
