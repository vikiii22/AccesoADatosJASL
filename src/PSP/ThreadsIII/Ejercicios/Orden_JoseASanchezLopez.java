package PSP.ThreadsIII.Ejercicios;

import java.util.concurrent.Semaphore;

public class Orden_JoseASanchezLopez extends Thread {
    String texto;
    Semaphore s;

    public Orden_JoseASanchezLopez(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            System.out.println(texto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Orden2 extends Thread {
    Contador contador=new Contador(0);
    String texto;
    Semaphore s;

    public Orden2(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            contador.incremento();
            s.acquire();
            System.out.println(texto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.release();
    }
}

class Contador {
    int contador = 0;

    public Contador(int contador) {
        this.contador = contador;
    }

    public Contador() {
    }

    public synchronized void incremento() {
        contador++;
    }

    public synchronized int value() {
        return contador;
    }
}

class EjecutaOrden {
    public static void main(String[] args) throws InterruptedException {
        Contador contador=new Contador(0);
        Semaphore sem = new Semaphore(contador.value());

        Thread orden1 = new Thread(new Orden_JoseASanchezLopez("Es un ejercicio de semáforos By: Jose", sem));
        Thread orden2 = new Thread(new Orden2("Esto no es una copia", sem));

        orden2.start();
        sem.release();
        orden1.start();
    }
}
