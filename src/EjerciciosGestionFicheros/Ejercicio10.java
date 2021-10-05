package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        escribirObjeto();
        leerObjeto();
    }

    private static void escribirObjeto() {
        try {
            FileOutputStream file = new FileOutputStream("BookFile.dat");
            ObjectOutputStream ous = new ObjectOutputStream(file);
            ous.writeObject(new Book("libro 1", "Santillana", 2015) + "\n");
            ous.writeObject(new Book("libro 2", "Barco de vapor", 2020) + "\n");
            ous.writeObject(new Book("libro 3", "Merlín", 2011) + "\n");
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerObjeto() {
        try {
            FileInputStream file = new FileInputStream("BookFile.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            Object object=ois.readObject();
            Book b = (Book) object;
            for (int i = 0; i < object.toString().length(); i++) {
                System.out.println(b.getInfo());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
