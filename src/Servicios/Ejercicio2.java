package Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) {
        //String comando = "calc.exe"; Lo hago con notepad, porque la calculadora cierra el proceso sola y se salta el waitFor().
        String comando = "notepad.exe";
        Process p = null;

        try {
            p = Runtime.getRuntime().exec(comando);
            p.waitFor();
            System.out.println("La aplicación se ha cerrado con éxtio");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
