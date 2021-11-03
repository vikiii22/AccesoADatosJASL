package PSP.Threads;

public class DosHilosInterrupt extends Thread {
    int id;

    public DosHilosInterrupt(int id) {
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

class UsandoDosHilosConSleep2Interrupt extends Thread{
    int id;

    public UsandoDosHilosConSleep2Interrupt(int id) {
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

class EjecutandoSleepInterrupt {
    public static void main(String[] args) {
        Thread hilo1=new Thread(new DosHilosInterrupt(1));
        Thread hilo2=new Thread(new UsandoDosHilosConSleep2Interrupt(2));

        hilo1.start();
        hilo2.start();
    }
}
