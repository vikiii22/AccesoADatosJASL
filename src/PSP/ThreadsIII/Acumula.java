package PSP.ThreadsIII;

import java.util.concurrent.Semaphore;

public class Acumula {
    public static int acumulador=0;
}

class Sumador extends Thread{

    private int cuenta;
    private Semaphore sem;

    public Sumador(int cuenta, Semaphore sem, int id) {
        this.cuenta = cuenta;
        this.sem = sem;
    }

    public void sumar(){
        Acumula.acumulador++;
    }

    @Override
    public void run() {
        for (int i = 0; i < cuenta; i++) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sumar();
            sem.release();
        }
    }
}

class SeccionCriticaSemaforos{
    private static Sumador sumadores[];
    private static Semaphore semaphore=new Semaphore(1);

    public static void main(String[] args) {
        int n_sum=Integer.parseInt(args[0]);
        sumadores=new Sumador[n_sum];
        for (int i = 0; i < n_sum; i++) {
            sumadores[i]=new Sumador(100000, semaphore, i);
            sumadores[i].start();
        }

        for (int i = 0; i < n_sum; i++) {
            try {
                sumadores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Acumulador: " + Acumula.acumulador);
    }
}


