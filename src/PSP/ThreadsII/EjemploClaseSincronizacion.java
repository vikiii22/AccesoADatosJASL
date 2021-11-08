package PSP.ThreadsII;

public class EjemploClaseSincronizacion extends Thread{
    int num;
    ContadorCompartido contador;

    public EjemploClaseSincronizacion(int num){
        this.num=num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            contador.sumar();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ContadorCompartido{
    int contador=0;

    public ContadorCompartido(int contador) {
        this.contador = contador;
    }

    public void sumar(){
        contador=contador+1;
    }

    public void restar(){
        contador=contador-1;
    }
}

class Restador extends Thread{
    int num;
    ContadorCompartido contador;

    public Restador(int num){
        this.num=num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            contador.restar();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EjecutarContador{
    public static void main(String[] args) {
        Thread ej=new Thread(new EjemploClaseSincronizacion(4));
        Thread ej2=new Thread(new Restador(4));

        ej.start();
        ej2.start();
    }
}