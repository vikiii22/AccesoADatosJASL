package PSP.ThreadsII.EjerciciosRepaso;

public class Ej4Mihilo2Modificado extends Thread{
    private int id;

    public Ej4Mihilo2Modificado(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Mi hilo 4" + id + " modificando hilo 1");
    }
}

class EjecutaEJ4{
    public static void main(String[] args) {
        Thread t=new Thread(new Ej4Mihilo2Modificado(4));
        t.start();
    }
}
