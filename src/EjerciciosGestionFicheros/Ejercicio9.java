package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) throws IOException {
        crearFichero();
        leerFichero();
    }

    private static void crearFichero() throws IOException {
        File file = new File("BinaryFile.dat");
        try {
            FileOutputStream dir = new FileOutputStream(file);
            DataOutputStream salida = new DataOutputStream(dir);

            String titulos[] = {"Les tenebres i l'alba", "El Quixot de la Manxa", "El Senyor dels Anells", "El petit Princep"};
            int anyoPublicacion[] = {2020, 1605, 1954, 1943};

            for (int i = 0; i < titulos.length; i++) {
                salida.writeUTF(titulos[i]);
                salida.writeInt(anyoPublicacion[i]);
                salida.writeChars("\n");
            }
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero() {
        File file = new File("BinaryFile.dat");
        String libros;
        int anyo;
        try {
            DataInputStream salida = new DataInputStream(new FileInputStream(file));
            while ((libros=salida.readUTF())!=null) {
                anyo = salida.readInt();
                salida.readChar();
                System.out.println(libros + " " + anyo);
            }
            salida.close();

        } catch (IOException e) {
            e.getCause();
        }
    }
}