package PSP.ThreadsII;

import java.util.Scanner;

public class Ejercicio2Hilos2_JoseASanchezLopez extends Thread {
    int numero;

    @Override
    public void run() {
        System.out.println("Ingresa un número mayor a 10: ");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();

        if (numero < 10) {
            System.out.println("Número no válido");
            System.exit(1);
        } else {
            System.out.println("Hilo 1");
            for (int i = 0; i <= numero; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

class RecorridoInverso extends Thread{
    int numero;

    @Override
    public void run() {
        System.out.println("Ingresa un número mayor a 10: ");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();

        if (numero < 10) {
            System.out.println("Número no válido");
            System.exit(1);
        } else {
            System.out.println("Hilo 2");
            for (int i = numero; i >= 0; i--) {
                System.out.print(i + " ");
            }
        }
    }
}

class EjecutaEJ2{
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Ejercicio2Hilos2_JoseASanchezLopez());
        Thread t2=new Thread(new RecorridoInverso());
        t.start();
        t.join();
        System.out.println();
        t2.start();
    }
}
