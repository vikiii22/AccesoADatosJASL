package PSP.ThreadsII;

public class Ejercicio1Hilos2_JoseASanchezLopez extends Thread{
    String palabra;

    public Ejercicio1Hilos2_JoseASanchezLopez(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(palabra + ": " +i);
            int tiempo=(int)(Math.random()*3000);
            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class EjecutarEjercicio1{
    public static void main(String[] args) {
        Thread hola=new Thread(new Ejercicio1Hilos2_JoseASanchezLopez("Hola"));
        Thread adios=new Thread(new Ejercicio1Hilos2_JoseASanchezLopez("Adiós"));

        hola.start();
        adios.start();
    }
}
