package PSP.ThreadsII;

import java.io.*;

public class Ejercicio4Hilos2_JoseASanchezLopez extends Thread{
    @Override
    public void run() {
        File archivo=new File("Prueba.txt");
        for (int i = 11; i <= 20; i++) {
            try {
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo, true));
                bw.write(""+i+"\n");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hilo2Ejercicio4 extends Thread{
    @Override
    public void run() {
        File archivo = new File("Prueba.txt");
        for (int i = 21; i <= 30; i++) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
                bw.write("" + i + "\n");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hilo3Ejercicio4 extends Thread{
    @Override
    public void run() {
        File archivo=new File("Prueba.txt");
        for (int i = 1; i <= 10; i++) {
            try {
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo, true));
                bw.write("" + i + "\n");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class EjecutaEJ4Hilos2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t=new Thread(new Ejercicio4Hilos2_JoseASanchezLopez());
        Thread t2=new Thread(new Hilo2Ejercicio4());
        Thread t3=new Thread(new Hilo3Ejercicio4());
        t.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t.start();
        t2.start();
        t3.start();

        /*BufferedReader br=new BufferedReader(new FileReader("Prueba.txt"));
        String linea;
        while ((linea=br.readLine())!=null){
            System.out.println(linea);
        }*/
    }
}