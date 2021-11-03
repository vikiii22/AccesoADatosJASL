package PSP.Threads;

public class CarreraAnimales extends Thread {
    String mascota;
    int tiempo;
    int prioridad;


    public CarreraAnimales(String mascota, int tiempo, int prioridad) {
        this.mascota = mascota;
        this.tiempo = tiempo;
        this.prioridad = prioridad;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(mascota + " en km " + i);
            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setPriority(prioridad);
        }
        //Thread.yield();
        /*try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}

class MascotasMain {
    public static void main(String[] args) {
        Thread ej1 = new Thread(new CarreraAnimales("Caracol", 300, Thread.MIN_PRIORITY));
        Thread ej2 = new Thread(new CarreraAnimales("Gato", 1500, Thread.NORM_PRIORITY));
        Thread ej3 = new Thread(new CarreraAnimales("Cocodrilo", 1000, Thread.MIN_PRIORITY));

        ej1.start();
        ej2.start();
        ej3.start();
    }
}
