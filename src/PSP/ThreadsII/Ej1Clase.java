package PSP.ThreadsII;

public class Ej1Clase implements Runnable {
    Thread t;
    Ej1Clase() {
        t = new Thread();
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Mi hilo 1");
    }
}

class EjecutaHilo1{
    public static void main(String[] args) {
        new Ej1Clase().run();
    }
}
