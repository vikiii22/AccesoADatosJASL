package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        escribirObjeto();
        leerObjeto();
    }

    private static void escribirObjeto() {
        Book b1 = new Book("libro 1", "Santillana", 2015);
        Book b2 = new Book("libro 2", "Barquito", 2020);
        Book b3 = new Book("libro 3", "Sombrilla", 2021);
        try {
            FileOutputStream file = new FileOutputStream("BookFile.dat");
            ObjectOutputStream ous = new ObjectOutputStream(file);
            ous.writeObject(b1);
            ous.writeObject(b2);
            ous.writeObject(b3);
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerObjeto() {
        try {
            FileInputStream file = new FileInputStream("BookFile.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            Book libro = (Book) ois.readObject();
            while (libro != null) {
                libro.getInfo();
                libro = (Book) ois.readObject();
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getCause();
        }
    }
}
