package Servicios.Ejercicio1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

//Ejercicio 1.9
public class Ejericio1_9 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        ProcessBuilder pb2 = new ProcessBuilder("ipconfig");

        Process p = pb.start();
        Process p2 = pb2.start();

        String lineas;
        //Salida dato hijo a padre
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        //Entrada dato hijo a padre
        PrintStream ps = new PrintStream(p2.getOutputStream());
        while ((lineas = br.readLine()) != null) {
            ps.append(lineas);
            //ps.println(lineas); Supuestamente imprime lineas pero no lo hace
            //System.out.println(lineas);
            //ps.println(lineas);
        }
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        while ((lineas=br2.readLine()) != null) {
            ps.println();
            System.out.println(lineas);
        }
        br.close();
    }
}
