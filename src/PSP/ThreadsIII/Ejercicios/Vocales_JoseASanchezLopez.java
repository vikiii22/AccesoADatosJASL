package PSP.ThreadsIII.Ejercicios;

import java.util.concurrent.Semaphore;

public class Vocales_JoseASanchezLopez extends Thread{
    int vocal=0;
    String texto;
    Semaphore s;

    public Vocales_JoseASanchezLopez(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)=='a'||texto.charAt(i)=='A'){
                vocal++;
            }
        }
        System.out.println("A: " + vocal);
        s.release();
    }

    public int getVocal() {
        return vocal;
    }
}

class VocalE extends Thread{
    int vocal;
    String texto;
    Semaphore s;

    public VocalE(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }


    @Override
    public void run() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)=='e' || texto.charAt(i)=='E'){
                vocal++;
            }
        }
        System.out.println("E: " + vocal);
        s.release();
    }
}

class VocalI extends Thread{
    int vocal;
    String texto;
    Semaphore s;

    public VocalI(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)=='i' || texto.charAt(i)=='I'){
                vocal++;
            }
        }
        System.out.println("I: " + vocal);
        s.release();
    }
}

class VocalO extends Thread{
    int vocal;
    String texto;
    Semaphore s;

    public VocalO(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)=='o' || texto.charAt(i)=='O'){
                vocal++;
            }
        }
        System.out.println("O: " + vocal);
        s.release();
    }
}

class VocalU extends Thread{
    int vocal;
    String texto;
    Semaphore s;

    public VocalU(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)=='u' || texto.charAt(i)=='U'){
                vocal++;
            }
        }
        System.out.println("U: " + vocal);
        s.release();
    }
}

class EjecutaVocal{
    public static void main(String[] args) {
        String texto="Hola mi nombre es Jose, estoy en 2 de DAM, usted quien es?";
        Semaphore sem=new Semaphore(0);

        Thread a=new Thread(new Vocales_JoseASanchezLopez(texto, sem));
        Thread e=new Thread(new VocalE(texto, sem));
        Thread i=new Thread(new VocalI(texto, sem));
        Thread o=new Thread(new VocalO(texto, sem));
        Thread u=new Thread(new VocalU(texto, sem));

        a.start();
        e.start();
        i.start();
        o.start();
        u.start();
    }
}