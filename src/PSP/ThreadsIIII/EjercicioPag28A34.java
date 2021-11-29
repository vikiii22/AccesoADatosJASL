package PSP.ThreadsIIII;

public class EjercicioPag28A34 {
    private final static int ITEMS = 20;
    public static Buffer b;

    public static void main(String[] args) {
        b = new Buffer1();

        Thread productor = new Productor("Productor ", ITEMS, b);
        Thread consumidor = new Consumidor("Consumidor ", ITEMS, b);

        System.out.println("Inicio");
        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin");
    }
}

class Productor extends Thread {
    public final static long DELAY = 100L;

    private int n;
    private Buffer b;

    public Productor(String nombre, int n, Buffer b) {
        super(nombre);
        this.n = n;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i <= n; i++) {
            try {
                b.producir(i);
                System.out.println(Thread.currentThread().getName() + " ha producido " + i);
                long delay = (long) (Math.random() * DELAY);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumidor extends Thread {
    public final static long DELAY = 200L;

    private int n;
    private Buffer b;

    public Consumidor(String nombre, int n, Buffer b) {
        super(nombre);
        this.n = n;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i <= n; i++) {
            try {
                int v = b.consumir();
                System.out.println(Thread.currentThread().getName() + " ha consumido: " + v);
                long delay = (long) (Math.random() * DELAY);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

abstract class Buffer {
    public final static int BUFFER_SIZE = 10;
    private int buffer[];
    protected int posProd, posCons;
    protected int cont;

    public Buffer() {
        buffer = new int[BUFFER_SIZE];
        posProd = posCons = cont = 0;
    }

    public int items() {
        return cont;
    }

    public boolean lleno() {
        return cont == BUFFER_SIZE;
    }

    public boolean vacio() {
        return cont == 0;
    }

    public void produccion(int v) {
        buffer[posProd] = v;
        posProd = (posProd + 1) % BUFFER_SIZE;
        cont++;
    }

    protected int consumicion() {
        int v = buffer[posCons];
        posCons = (posCons++ % BUFFER_SIZE);
        cont--;
        return v;
    }

    public abstract void producir(int v) throws InterruptedException;

    public abstract int consumir() throws InterruptedException;
}

class Buffer1 extends Buffer {
    public void producir(int v) throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (lleno()) {
            System.out.println(thread.getName() + " esperando ( buffer lleno )..."

            );
        }
        produccion(v);
    }

    public int consumir() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (vacio()) {
            System.out.println(thread.getName() + " esperando ( buffer vacio )...");
        }
        int v = consumicion();
        return v;
    }
}

class Buffer2 extends Buffer {
    public synchronized void producir(int v) throws InterruptedException {
        Thread thread = Thread.currentThread();
        if (lleno()) {
            System.out.println(thread.getName() + " esperando ( buffer lleno )...");
            wait();
        }
        produccion(v);
        notify();
    }

    public synchronized int consumir() throws InterruptedException {
        Thread thread = Thread.currentThread();
        if (vacio()) {
            System.out.println(thread.getName() + " esperando ( buffer vacio )...");
            wait();
        }
        int v = consumicion();
        notify();
        return (v);
    }
}