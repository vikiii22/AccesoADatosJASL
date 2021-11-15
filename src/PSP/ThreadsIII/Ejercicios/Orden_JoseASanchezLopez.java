package PSP.ThreadsIII.Ejercicios;

import java.util.concurrent.Semaphore;

public class Orden_JoseASanchezLopez extends Thread {
    Semaphore s = new Semaphore(1);
    String texto;

    public Orden_JoseASanchezLopez(String texto) {
        this.texto = texto;
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
        } finally {
            s.release();
        }
    }
}

class EjecutaOrden{
    public static void main(String[] args) throws InterruptedException {

        Thread orden1 = new Thread(new Orden_JoseASanchezLopez("Probando semáforos 1:"));
        Thread orden2 = new Thread(new Orden_JoseASanchezLopez("Probando semáforos 2:"));

        orden1.start();
        orden2.start();
    }
}
