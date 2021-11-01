package PSP.Threads;

import java.util.Scanner;

public class FibonacciSleep extends Thread {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        int numero, fibo1, fibo2, i;
        System.out.print("Introduce cuantos números quieres: ");
        numero = sc.nextInt();

        while (numero <= 1) System.out.println(numero);

        fibo1 = 1;
        fibo2 = 1;

        System.out.print(fibo1 + " ");
        for (i = 2; i < numero; i++) {
            try {
                sleep(1500);
                System.out.print(fibo2 + " ");
                fibo2 = fibo1 + fibo2;
                fibo1 = fibo2 - fibo1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EjectutaFiboConSleep {
    public static void main(String[] args) {
        new Fibonacci_EJ1_JoseASanchezLopez().start();
        System.out.println("Serie Fibonacci");
    }
}