package PSP.ThreadsIIII;

public class Relevos extends Thread{
    String nombre;
    int testigo;
    int metros;
    Carrera carrera=new Carrera(testigo);


    public Relevos(String nombre, int testigo, int metros) {
        this.nombre = nombre;
        this.testigo=testigo;
        this.metros=metros;
    }


    @Override
    public void run() {
        while (metros!=0){
            try {
                int num=(int) (Math.random()*4);
                if (num==testigo) {
                    System.out.println("Corredor: " + nombre);
                    System.out.println("Faltan: " + metros + " metros");
                }
                carrera.carreraLibre();
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            carrera.carreraOcupada();
            System.out.println(nombre + " descansando...");
            System.out.println();
            metros-=10;
        }
    }
}


class Carrera {
    boolean corriendo=true;
    Object testigo=new Object();

    public Carrera(Object testigo) {
        this.testigo = testigo;
    }

    public synchronized void carreraLibre() throws InterruptedException {
        while (!corriendo)
            wait();
        System.out.println("Sigue corriendo");
        corriendo=false;
    }

    public synchronized void carreraOcupada(){
        corriendo=true;
        System.out.println("Para");
        notify();
    }
}

class EjecutaRelevos{
    public static void main(String[] args) {
        int metros=300;

        Relevos relevos1=new Relevos("Juan", 1, metros);
        Relevos relevos2=new Relevos("Miguel", 2, metros);
        Relevos relevos3=new Relevos("María", 3, metros);
        Relevos relevos4=new Relevos("Ana", 4, metros);

        relevos1.start();
        relevos2.start();
        relevos3.start();
        relevos4.start();

        try {
            relevos1.join();
            relevos2.join();
            relevos3.join();
            relevos4.join();
            System.out.println("Carrera finalizada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
