package Servicios.Threads;

public class EjemplosHilos implements Runnable{
    Thread t;
    EjemplosHilos(){
        t=new Thread(this, "Nuevo hilo");
        System.out.println("Creando hilo " + t);
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Hola desde el hilo creado");
        System.out.println("Hilo finalizado");
    }
}
class RunThread{
    public static void main(String[] args) {
        new EjemplosHilos();
        System.out.println("Hola hilo principal");
        System.out.println("Proceso acabado");
    }
}
