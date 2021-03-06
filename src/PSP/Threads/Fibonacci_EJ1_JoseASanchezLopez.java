package PSP.Threads;

import java.util.Scanner;

public class Fibonacci_EJ1_JoseASanchezLopez extends Thread {
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
        for (i = 1; i < numero ; i++) {
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
    }
}

class EjectutaFibo {
    public static void main(String[] args) {
        new Fibonacci_EJ1_JoseASanchezLopez().start();
        System.out.println("Serie Fibonacci");
    }
}
