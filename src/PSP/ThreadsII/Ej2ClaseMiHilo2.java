package PSP.ThreadsII;

public class Ej2ClaseMiHilo2 extends Thread{
    @Override
    public void run() {
        System.out.println("Mi hilo 2");
    }
}

class Ej2Ejecuta{
    public static void main(String[] args) {
        //new Ej2ClaseMiHilo2().start();
        Thread t=new Thread(new Ej2ClaseMiHilo2());
        t.start();
    }
}
