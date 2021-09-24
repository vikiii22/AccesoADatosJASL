import java.io.File;
import java.util.Scanner;

public class EjemploFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Añade un directorio: ");
        String directorio = sc.nextLine();

        File ejemplo=new File("ejemplo.txt");

        File leido=new File(directorio);
        for (File f:leido.listFiles()) {
            System.out.println(f);
            /*if (f.isFile()){
                System.out.println(f.listFiles());
            }else{
                System.out.println(f.listFiles());
            }*/
        }

        System.out.println("----------------");

        System.out.println(ejemplo.getName());
        System.out.println(ejemplo.getPath());
        System.out.println(ejemplo.getAbsolutePath());
        System.out.println(ejemplo.exists());
        System.out.println(ejemplo.canWrite());
        System.out.println(ejemplo.canRead());
        System.out.println(ejemplo.isFile() + " Es fichero");
        System.out.println(ejemplo.isDirectory());
        System.out.println(ejemplo.isAbsolute());
        System.out.println(ejemplo.lastModified());
        System.out.println(ejemplo.length());
        System.out.println(ejemplo.mkdir());
        System.out.println(ejemplo.mkdirs());
        //ejemplo.renameTo(new File("ejemplo2"));
    }
}
