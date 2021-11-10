package PSP.ThreadsII.EjerciciosRepaso;

public class Ej6_f implements Runnable {
    private int veces;
    Thread t;
    String nombre;

    public Ej6_f(int veces, String nombre) {
        t = new Thread(this, nombre);
        this.veces = veces;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= veces; i++) {
            System.out.println("Mi hilo 6: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EjecutaEj6{
    public static void main(String[] args) {
        Thread t=new Thread(new Ej6_f(5, "Mi hilo 6 "));
        t.start();
    }
}