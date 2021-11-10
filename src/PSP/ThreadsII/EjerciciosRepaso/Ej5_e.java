package PSP.ThreadsII.EjerciciosRepaso;

public class Ej5_e implements Runnable{
    Thread t;
    private int id;
    public Ej5_e(int id) {
        t = new Thread(this, "Hilo 1 modificado");
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Hilo 5 "+ id + " :)");
    }
}

class EjecutaEj5{
    public static void main(String[] args) {
        Thread t=new Thread(new Ej5_e(5));
        t.start();
    }
}