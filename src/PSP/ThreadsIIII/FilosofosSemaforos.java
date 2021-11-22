package PSP.ThreadsIIII;

import java.util.concurrent.Semaphore;

public class FilosofosSemaforos extends Thread {
    Semaphore palillo1, palillo2;
    String nombre;
    String palilloI;
    String palilloD;

    public FilosofosSemaforos(Semaphore izq, Semaphore derecha, String nombre, String palilloD, String palilloI) {
        this.palillo1 = izq;
        this.palillo2 = derecha;
        this.nombre = nombre;
        this.palilloI=palilloI;
        this.palilloD=palilloD;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        try {
            //se supone que los filósofos están siempre pensando(bucle infinito)...
            //pero le ponemos un total de 3 vueltas
            //System.out.println("El filosofo "+getNombre()+" entra en juego... ");
            int i = 0;
            while (i < 3) {
                palillo1.acquire();
                palillo2.acquire();
                System.out.println("El filósofo: " + getNombre() + " coge el palillo: "+palilloI);
                System.out.println("El filósofo: " + getNombre() + " coge el palillo: "+palilloD);


                //si el filósofo ha conseguido coger los dos palillos, come durante un tiempo:
                System.out.println(getNombre() + " se pone a comer..... ");
                sleep((int) (Math.random() * 2000 + 1000));

                //Suelta los palillos y piensa durante un tiempo
                System.out.println("Suelta los palillos y vuelve a pensar... ");
                palillo1.release();
                palillo2.release();
                System.out.println();
                sleep((int) (Math.random() * 2000 + 1000));
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Error en ejecución Filósofo.");
        }
    }
}

class FilosofosSemaforosEjecuta {
    public static void main(String[] args) {
        Semaphore palillo1 = new Semaphore(1);
        Semaphore palillo2 = new Semaphore(1);
        Semaphore palillo3 = new Semaphore(1);
        Semaphore palillo4 = new Semaphore(1);
        Semaphore palillo5 = new Semaphore(1);

        FilosofosSemaforos f1 = new FilosofosSemaforos(palillo1, palillo2, "F1", "2", "1");
        FilosofosSemaforos f2 = new FilosofosSemaforos(palillo2, palillo3, "F2", "3", "2");
        FilosofosSemaforos f3 = new FilosofosSemaforos(palillo3, palillo4, "F3", "4", "3");
        FilosofosSemaforos f4 = new FilosofosSemaforos(palillo4, palillo5, "F4", "5", "4");
        FilosofosSemaforos f5 = new FilosofosSemaforos(palillo5, palillo1, "F5", "1", "5");

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
            f5.join();
        } catch (InterruptedException e) {
            System.out.println("Error en ejecución Filósofo.");
        }
    }
}
