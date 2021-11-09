package PSP.ThreadsII;

import java.io.*;

public class Ejercicio3Hilos2_JoseASanchezLopez extends Thread{
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

class Hilo2Ejercicio3 extends Thread{
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

class Hilo3Ejercicio3 extends Thread{
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

class EjecutaEJ3Hilos2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t=new Thread(new Ejercicio3Hilos2_JoseASanchezLopez());
        Thread t2=new Thread(new Hilo2Ejercicio4());
        Thread t3=new Thread(new Hilo3Ejercicio4());
        t.start();
        t.join();
        t2.start();
        t2.join();
        t3.start();

        /**
         * Aquí he usado los join() porque no sabía si en el ejercicio se pedía que esperase a la finalización de
         * cada hilo o si daba igual que estuviese desorganizado
         */
    }
}
