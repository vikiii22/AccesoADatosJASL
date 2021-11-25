package PSP.ThreadsIIII;

public class Ejercicio25 {
    public static void main(String[] args) {
        Thread t = new Ejecutor();
        Thread t2 = new Ejecutor();

        t.start();
        t2.start();

        try {
            t.join();
            t2.join();
            System.out.println("Acabada la suma");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Estadistica {
    double sum, media;
    int cont;

    public Estadistica() {
        sum = 0.0;
        cont = 0;
    }

    public void nuevoValor(double v) {
        synchronized (this) {
            sum = sum + v;
            cont++;
            media = sum / cont;
            System.out.println(media);
        }
    }
}

class Ejecutor extends Thread {
    Estadistica e = new Estadistica();

    @Override
    public void run() {
        int aleatorio = 0;
        for (int i = 0; i < 10; i++) {
            aleatorio += ((int) (Math.random() * 100));
            e.nuevoValor(aleatorio);
        }
        System.out.println("Suma total: " + e.sum);
    }
}