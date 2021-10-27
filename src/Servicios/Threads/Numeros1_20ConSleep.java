package Servicios.Threads;

public class Numeros1_20ConSleep extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                System.out.print(i + " ");
                sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EjecutaConSleep{
    public static void main(String[] args) {
        new Numeros1_20ConSleep().start();
        System.out.println("USANDO SLEEP");
    }
}