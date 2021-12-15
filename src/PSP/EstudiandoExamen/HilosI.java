package PSP.EstudiandoExamen;

import java.util.concurrent.Semaphore;

public class HilosI extends Thread {
    String nombre;
    int id;
    Semaphore s = new Semaphore(1);

    public HilosI(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = id; i <= id + 10; i++) {
                System.out.println("Hola " + nombre + " con id: " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.release();
    }
}

class Ejecucion {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new HilosI("Juan", 5));
        Thread t2 = new Thread(new HilosI("Fernando", 2));

        t.start();
        //t.join();
        t2.start();
    }
}
