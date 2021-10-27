package PSP.Threads;

public class Ejercicios1_20 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.print(i+" ");
        }
    }
}

class Ejecuta{
    public static void main(String[] args) {
        new Ejercicios1_20().start();
        System.out.println("Números del 1 al 20:");
    }
}
