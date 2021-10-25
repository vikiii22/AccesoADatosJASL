package Servicios.Threads;

public class Ejemplo2 extends Thread{
    @Override
    public void run() {
        System.out.println("Hola desde el hilo");
    }
}
class RunThread2{
    public static void main(String[] args) {
        new Ejemplo2().start();
        System.out.println("Hola desde principal");
        System.out.println("Proceso acabado");
    }
}