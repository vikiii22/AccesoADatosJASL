package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        escribirObjeto();
        leerObjeto();
    }

    private static void escribirObjeto() {
        Book libro = new Book("libro 1", "Santillana", 2015);
        try {
            FileOutputStream file = new FileOutputStream("BookFile.dat");
            ObjectOutputStream ous = new ObjectOutputStream(file);
            for (int i = 0; i < 5; i++) {
                ous.writeObject(libro.nombre + " " + libro.editorial + " " + libro.fecha + "\n");
            }
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerObjeto() {
        try {
            FileInputStream file = new FileInputStream("BookFile.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            Object obj = ois.readObject();

            for (int i = 0; i < obj.toString().length(); i++) {
                System.out.println(obj);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
