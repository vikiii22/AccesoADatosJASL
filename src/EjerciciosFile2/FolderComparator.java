package EjerciciosFile2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderComparator {
    public void setFolders(File folderA, File folderB) throws UtilityFileException {
        if (!folderA.isDirectory() && !folderA.exists() || !folderB.isDirectory() && folderB.exists()) {
            UtilityFileException ufe = new UtilityFileException();
            System.out.println(ufe.error);
        }
    }

    public File getFolderA(File folderA) {
        System.out.println(folderA.getName());
        for (File f : folderA.listFiles()) {
            if (f.isFile()) {
                System.out.println("la ruta 1 contiene: " + f);
            }
        }
        return folderA;
    }

    public File getFolderB(File folderB) {
        System.out.println(folderB.getName());
        for (File f : folderB.listFiles()) {
            if (f.isFile()) {
                System.out.println("la ruta 2 contiene: " + f);
            }
        }
        return folderB;
    }

    public void compare(File folderA, File folderB) throws UtilityFileException {

        List<File> folderAList = new ArrayList<>();
        List<File> folderBList = new ArrayList<>();

        for (File f : folderA.listFiles()) {
            if (f.isFile()) {
                folderAList.add(f);
            }
        }

        for (File f : folderB.listFiles()) {
            if (f.isFile()) {
                folderBList.add(f);
            }
        }

        String salida = "";
        int iguales = 0;
        for (File f : folderAList) {
            for (File j : folderBList) {
                if (f.getName().equals(j.getName()) && f.lastModified() == j.lastModified() && f.length() == j.length()) {
                    salida += f.getName() + " : " + j.getName() + " : Son iguales\n";
                    iguales++;
                }
            }
        }
        System.out.println("-----------------------------");
        if (iguales == folderAList.size() && iguales == folderBList.size() && salida.contains("Son iguales")) {
            System.out.println("Los directorios son iguales, tienen en común:");
            System.out.println(salida + "");
        } else {
            System.out.println("No son iguales");
        }
    }
}
