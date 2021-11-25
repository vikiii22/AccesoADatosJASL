package PSP.ThreadsIIII;

public class Filosofos extends Thread {
    String nombre;
    Palillo izq, derecha;


    public Filosofos(String nombre, Palillo izq, Palillo derecha) {
        this.nombre = nombre;
        this.izq = izq;
        this.derecha = derecha;
    }


    public Palillo getIzq() {
        return izq;
    }

    public Palillo getDerecha() {
        return derecha;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public void run() {
        while (true) {
            while (!izq.estaOcupado() && !derecha.estaOcupado()) {
                tenedorOcupado();
                System.out.println("Está comiendo " + getNombre());
                System.out.println("Comiendo...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Ha terminado de comer " + getNombre());
                System.out.println("Pensando...");
                tenedorLibre();
                System.out.println();
            }
        }
    }

    public synchronized void tenedorOcupado() {
        izq.setOcupado(true);
        derecha.setOcupado(true);
        System.out.println(getNombre() + " Está comiendo... con los palillos " + izq.getNum() + " y " + derecha.getNum());
    }

    public synchronized void tenedorLibre() {
        izq.setOcupado(false);
        derecha.setOcupado(false);
        System.out.println("Suelta los palillos " + izq.getNum() + " y " + derecha.getNum());
    }
}


class Palillo {
    int num;
    boolean ocupado = false;

    public Palillo(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}

class FilosofosEjecucion {
    public static void main(String[] args) {

        Palillo p1 = new Palillo(1);
        Palillo p2 = new Palillo(2);
        Palillo p3 = new Palillo(3);
        Palillo p4 = new Palillo(4);
        Palillo p5 = new Palillo(5);

        Filosofos f1 = new Filosofos("F1", p1, p2);
        Filosofos f2 = new Filosofos("F2", p2, p3);
        Filosofos f3 = new Filosofos("F3", p3, p4);
        Filosofos f4 = new Filosofos("F4", p4, p5);
        Filosofos f5 = new Filosofos("F5", p5, p1);


        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}
