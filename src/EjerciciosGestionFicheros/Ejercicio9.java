package EjerciciosGestionFicheros;

import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) throws IOException {
        crearFichero();
        leerFichero();
    }

    private static void crearFichero() throws IOException {
        File file = new File("ejericio9.dat");
        try {
            FileOutputStream dir = new FileOutputStream(file);
            DataOutputStream salida = new DataOutputStream(dir);
            String[] titulos = {"Les tenebres i l'alba", "El Quixot de la Manxa", "El Senyor dels Anells", "El petit Princep"};
            int anyoPublicacion[] = {2020, 1605, 1954, 1943};
            for (int i = 0; i < titulos.length; i++) {
                for (int j = 0; j < anyoPublicacion.length; j++) {
                    salida.writeChars(titulos[i]);
                    salida.writeInt(anyoPublicacion[j]);
                }
            }
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero() {
        File file = new File("ejericio9.dat");
        String libros;
        try {
            FileInputStream dir=new FileInputStream(file);
            DataInputStream salida=new DataInputStream(dir);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}