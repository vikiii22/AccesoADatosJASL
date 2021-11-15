package PSP.ThreadsIII.Ejercicios;

import java.util.concurrent.Semaphore;

public class Orden_JoseASanchezLopez extends Thread {
    String texto;
    Semaphore s;

    public Orden_JoseASanchezLopez(String texto, Semaphore s) {
        this.texto = texto;
        this.s=s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = 1; i <= 10; i++) {
                System.out.println(texto + " " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class prueba2 extends Thread{
    String texto;
    Semaphore s;

    public prueba2(String texto, Semaphore s) {
        this.texto = texto;
        this.s=s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = 1; i <= 10; i++) {
                System.out.println(texto + " " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.release();
    }
}

class EjecutaOrden {
    public static void main(String[] args) throws InterruptedException {
        int contador=0;
        Semaphore sem=new Semaphore(contador);

        Thread orden1 = new Thread(new Orden_JoseASanchezLopez("Probando semáforos 1:", sem));
        Thread orden2 = new Thread(new prueba2("Probando semáforos 2:", sem));

        contador++;
        if (contador==1){
            orden2.start();
            sem.release();
        }
        orden1.start();

        //orden2.start();

    }
}
