package Ejercicio13;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class Ejercicio13 {
    public static void main(String[] args) throws FileNotFoundException {
        nombresProperties();
        System.out.println("-----------------------");
        nombreUsuario();
        emailUsuario();
        cambioIdioma();
        nuevaPropiedad();
    }

    private static void nombresProperties() throws FileNotFoundException {
        Properties properties = new Properties();
        FileReader fr = new FileReader("app.properties");
        try {
            properties.load(fr);
            Enumeration<Object> key = properties.keys();

            while (key.hasMoreElements()) {
                Object keys = key.nextElement();
                System.out.println(keys);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nombreUsuario() throws FileNotFoundException {
        Properties properties=new Properties();
        FileReader fr=new FileReader("app.properties");
        String nombreUsuario;
        try {
            properties.load(fr);
            nombreUsuario=properties.getProperty("userName", "Default");
            System.out.println(nombreUsuario);
            /*BufferedWriter bw=new BufferedWriter(new FileWriter("nombre.properties"));
            bw.write("Nombre usuario: " + nombre);
            bw.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void emailUsuario() throws FileNotFoundException {
        Properties properties=new Properties();
        FileReader fr=new FileReader("app.properties");
        String emailUsuario;
        try {
            properties.load(fr);
            emailUsuario=properties.getProperty("userEmail", "Default");
            System.out.println(emailUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cambioIdioma() throws FileNotFoundException {
        Properties properties=new Properties();
        FileReader fr=new FileReader("app.properties");
        System.out.print("Añada un idioma nuevo: ");
        Scanner sc=new Scanner(System.in);
        String cambio= sc.nextLine();
        try {
            properties.load(fr);
            properties.setProperty("language", cambio);
            properties.store(new FileWriter("app.properties"), "cambio de idioma");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nuevaPropiedad() throws FileNotFoundException {
        Properties properties=new Properties();
        FileReader fr=new FileReader("app.properties");
        Date date=new Date();
        try {
            properties.load(fr);
            properties.setProperty("appStarted", String.valueOf(date));
            properties.store(new FileWriter("app.properties"), "añandiendo propiedad con fecha");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
