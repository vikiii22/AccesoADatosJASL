package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        escribirObjeto();
        leerObjeto();
    }

    private static void escribirObjeto() {
        Book b1=new Book("libro 1", "Santillana", 2015);
        try {
            FileOutputStream file = new FileOutputStream("BookFile.dat");
            ObjectOutputStream ous = new ObjectOutputStream(file);
            ous.writeObject(b1+ "\n");
            ous.writeObject(new Book("libro 2", "Barco de vapor", 2020) + "\n");
            ous.writeObject(new Book("libro 3", "Merlín", 2011) + "\n");
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerObjeto() {
        Book b;
        try {
            FileInputStream file = new FileInputStream("BookFile.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            b=(Book) ois.readObject();
            b.getInfo();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
