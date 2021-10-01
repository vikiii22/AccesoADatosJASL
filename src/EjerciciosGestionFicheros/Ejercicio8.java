package EjerciciosGestionFicheros;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {
    static long bufTotal=System.currentTimeMillis();//Defino una variable para guardar el tiempo de bufferReader
    static long filTotal=System.currentTimeMillis();//Defino una variable para guardar el timpo de FileReader
    public static void main(String[] args) {
        escribirFichero();
        leerFichero();
        leerFileReader();

        if (bufTotal > filTotal){
            System.out.println("BufferedReader es más lento");
        }else {
            System.out.println("FileReader es más lento");
        }
    }

    private static void escribirFichero() {
        try {
            File file = new File("Ejercicio8.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            System.out.println("Introduce texto: ");
            Scanner sc = new Scanner(System.in);
            String escribe = sc.nextLine();
            bw.newLine();
            bw.write(escribe);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero() {
        try {
            File file = new File("loremIpsum.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String read;
            System.out.println(br.readLine());
            long inicio=System.currentTimeMillis();//Inicio del tiempo
            while ((read = br.readLine()) != null) {
                //System.out.println(read);
                BufferedWriter escribir = new BufferedWriter(new FileWriter("loremIpsum2.txt"));
                escribir.newLine();
                escribir.write(read);
                escribir.close();
            }
            long buf=System.currentTimeMillis();//Fin del timepo
            bufTotal=(buf - inicio);//Resto el último tiempo al primero
            System.out.println("BufferedReader " + bufTotal);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerFileReader() {
        try {
            File file = new File("loremIpsum.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String read;
            System.out.println(br.readLine());
            long inicio=System.currentTimeMillis();//Inicio del tiempo
            while ((read = br.readLine()) != null) {
                FileWriter escribir = new FileWriter("loremIpsum3.txt");
                escribir.write(read);
                escribir.close();
            }
            long fil=System.currentTimeMillis();//Fin del timepo
            filTotal=(fil - inicio);//Resto el último tiempo al primero
            System.out.println("FileReader " + filTotal);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
