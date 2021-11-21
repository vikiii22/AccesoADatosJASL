package PSP.ThreadsIII;

import java.util.Scanner;

public class Bienvenida extends Thread{
    boolean claseComenzada;

    public Bienvenida() {
        this.claseComenzada = false;
    }

    public synchronized void saludaProfesor(){
        try {
            while (claseComenzada==false){
                wait();
            }
            System.out.println("Buenos días, profesor.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void llegadaProfesor(String nombre){
        System.out.println("Buenos días a todos soy el profesor " + nombre);
        this.claseComenzada=true;
        notifyAll();
    }
}

class Alumno extends Thread{
    Bienvenida saludo;

    public Alumno (Bienvenida saludo){
        this.saludo=saludo;
    }

    @Override
    public void run() {
        System.out.println("Alumno llegó");
        try {
            Thread.sleep(1000);
            saludo.saludaProfesor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class Profesor extends Thread{
    String nombre;
    Bienvenida saludo;

    public Profesor(String nombre, Bienvenida saludo) {
        this.nombre = nombre;
        this.saludo = saludo;
    }

    @Override
    public void run() {
        System.out.println(nombre + " llegó");
        try {
            Thread.sleep(1000);
            saludo.llegadaProfesor(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ComienzaClase{
    public static void main(String[] args) {
        Bienvenida b=new Bienvenida();

        Scanner sc=new Scanner(System.in);
        System.out.print("Numero de alumnos: ");
        int alumnos=sc.nextInt();
        for (int i = 0; i < alumnos; i++) {
            new Alumno(b).start();
        }
        Profesor profesor=new Profesor("Juan", b);
        profesor.start();
    }
}