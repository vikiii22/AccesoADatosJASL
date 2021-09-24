package EjerciciosFile;

import java.io.File;

public class EjerciciosFile2 {
    public static void main(String[] args) {
        File actual=new File(".");
        for (String f:actual.list()) {
            System.out.println(f);
        }
    }
}
