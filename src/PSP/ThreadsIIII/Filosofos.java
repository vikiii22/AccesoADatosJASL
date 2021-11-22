package PSP.ThreadsIIII;

public class Filosofos extends Thread {
    String nombre;
    Tenedor izq, derecha;
    int id;

    public Filosofos() {

    }


    public Filosofos(String nombre, Tenedor izq, Tenedor derecha) {
        this.nombre = nombre;
        this.izq = izq;
        this.derecha = derecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public void run() {
        while (true){
            izq.tenedorLibre(id);
            derecha.tenedorLibre(id);
            System.out.println("Se dispone a comer " + getNombre());
            System.out.println();

            izq.tenedorOcupado(id);
            derecha.tenedorOcupado(id);
            System.out.println("Ha terminado de comer " + getNombre());
            System.out.println();
        }
    }
}

class Tenedor{
    int id;
    boolean libre=true;
    Filosofos f=new Filosofos();

    public Tenedor(String f ,int id) {
        this.id = id;
        this.f.setNombre(f);
    }

    public synchronized void tenedorLibre(int i){
        System.out.println(f.getNombre() + " coge el tenedor " + id);
        libre=false;
    }

    public synchronized void tenedorOcupado(int i){
        libre=true;
        System.out.println(f.getNombre() + " suelta el tenedor " + id);
        notify();
    }
}

class FilosofosEjecucion {
    public static void main(String[] args) {

        Tenedor t1=new Tenedor("F1", 1);
        Tenedor t2=new Tenedor("F2",2);
        Tenedor t3=new Tenedor("F3", 3);
        Tenedor t4=new Tenedor("F4", 4);
        Tenedor t5=new Tenedor("F5", 5);

        Filosofos f1 = new Filosofos("F1", t1, t2);
        Filosofos f2 = new Filosofos("F2", t2, t3);
        Filosofos f3 = new Filosofos("F3", t3, t4);
        Filosofos f4 = new Filosofos("F4", t4, t5);
        Filosofos f5 = new Filosofos("F5", t5, t1);


        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}
