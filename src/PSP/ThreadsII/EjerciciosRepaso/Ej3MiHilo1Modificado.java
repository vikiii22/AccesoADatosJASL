package PSP.ThreadsII.EjerciciosRepaso;

public class Ej3MiHilo1Modificado implements Runnable{
    Thread t;
    private int id;
    public Ej3MiHilo1Modificado(int id) {
        t = new Thread(this, "Hilo 1 modificado");
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Hilo 4 "+ id + " :)");
    }
}

class EjecutaEj3{
    public static void main(String[] args) {
        Thread t=new Thread(new Ej3MiHilo1Modificado(4));
        t.start();
    }
}