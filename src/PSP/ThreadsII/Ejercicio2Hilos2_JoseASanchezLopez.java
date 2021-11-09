package PSP.ThreadsII;

import java.util.Scanner;

public class Ejercicio2Hilos2_JoseASanchezLopez extends Thread {
    int numero;
    int retardo;

    public Ejercicio2Hilos2_JoseASanchezLopez(int numero, int retardo) {
        this.numero = numero;
        this.retardo = retardo;
    }

    @Override
    public void run() {
        if (numero < 10) {
            System.out.println("Número no válido");
            System.exit(1);
        } else {
            System.out.println("Hilo 1");
            for (int i = 0; i <= numero; i++) {
                System.out.print(i + " ");
                try {
                    sleep(retardo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RecorridoInverso extends Thread {
    int numero;
    int retardo;

    public RecorridoInverso(int numero, int retardo) {
        this.numero = numero;
        this.retardo = retardo;
    }

    @Override
    public void run() {
        if (numero < 10) {
            System.out.println("Número no válido");
            System.exit(1);
        } else {
            System.out.println("Hilo 2");
            for (int i = numero; i >= 0; i--) {
                System.out.print(i + " ");
                try {
                    sleep(retardo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class EjecutaEJ2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número mayor que 10: ");
        int numero = sc.nextInt();
        int retardo=(int)(Math.random()*1000);

        Thread t = new Thread(new Ejercicio2Hilos2_JoseASanchezLopez(numero, retardo));
        Thread t2 = new Thread(new RecorridoInverso(numero, retardo));
        t.start();
        t.join();
        System.out.println();
        t2.start();
    }
}
