package PSP.Threads;

public class EjUD4_Ej4_JoseASancheLopez extends Thread {
    int id;

    public EjUD4_Ej4_JoseASancheLopez(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " del hilo " + id);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class UsandoDosHilosConSleep2 extends Thread{
    int id;

    public UsandoDosHilosConSleep2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " del hilo " + id );
                sleep(1500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class EjecutandoSleep{
    public static void main(String[] args) {
        Thread hilo1=new Thread(new EjUD4_Ej4_JoseASancheLopez(1));
        Thread hilo2=new Thread(new UsandoDosHilosConSleep2(2));

        hilo1.start();
        hilo2.start();
    }
}