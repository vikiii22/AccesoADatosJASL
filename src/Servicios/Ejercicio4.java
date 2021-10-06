package Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.print("Introduce un parámetro: ");
        Scanner sc = new Scanner(System.in);
        String comando = sc.nextLine();
        String line;
        Process p = null;
        InputStream is;
        BufferedReader bf;

        try {
            if (comando.isEmpty()) {
                System.err.println("No puede estar vacío");
                System.exit(-1);
            }
            p = Runtime.getRuntime().exec(comando);
            is = p.getInputStream();
            bf = new BufferedReader(new InputStreamReader(is));
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-----------------------");
            System.out.println("Aplicación finalizada");
        } catch (IOException e) {
            System.err.println("Parámetro mal introducido");
        }
    }
}
