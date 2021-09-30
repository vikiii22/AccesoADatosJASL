package EjerciciosGestionFicheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        escribirFichero();
        leerFichero();
    }

    private static void escribirFichero() {
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("Ejercicio8.txt", true));
            System.out.println("Introduce texto: ");
            Scanner sc=new Scanner(System.in);
            String escribe= sc.nextLine();
            bw.newLine();
            bw.write(escribe);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("Ejercicio8.txt"));
            int read=0;
            System.out.println(br.readLine());

            /*while ((read = br.read())!=-1){
                System.out.println(br.readLine());
            }*/
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
