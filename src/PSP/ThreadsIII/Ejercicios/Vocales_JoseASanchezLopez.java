package PSP.ThreadsIII.Ejercicios;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Vocales_JoseASanchezLopez extends Thread {
    int vocal = 0;
    String texto;
    Semaphore s;

    public Vocales_JoseASanchezLopez(String texto, Semaphore s) {
        this.texto = texto;
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'A') {
                vocal++;
            }
        }
        if (vocal == 1) {
            System.out.println("La A aparece: " + vocal + " vez");
        } else {
            System.out.println("La A aparece: " + vocal + " veces");
        }
        s.release();
    }
}

class VocalE extends Thread {
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
            if (texto.charAt(i) == 'e' || texto.charAt(i) == 'E') {
                vocal++;
            }
        }
        if (vocal == 1) {
            System.out.println("La E aparece: " + vocal + " vez");
        } else {
            System.out.println("La E aparece: " + vocal + " veces");
        }
        s.release();
    }
}

class VocalI extends Thread {
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
            if (texto.charAt(i) == 'i' || texto.charAt(i) == 'I') {
                vocal++;
            }
        }
        if (vocal == 1) {
            System.out.println("La I aparece: " + vocal + " vez");
        } else {
            System.out.println("La I aparece: " + vocal + " veces");
        }
        s.release();
    }
}

class VocalO extends Thread {
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
            if (texto.charAt(i) == 'o' || texto.charAt(i) == 'O') {
                vocal++;
            }
        }
        if (vocal == 1) {
            System.out.println("La O aparece: " + vocal + " vez");
        } else {
            System.out.println("La O aparece: " + vocal + " veces");
        }
        s.release();
    }
}

class VocalU extends Thread {
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
            if (texto.charAt(i) == 'u' || texto.charAt(i) == 'U') {
                vocal++;
            }
        }
        if (vocal == 1) {
            System.out.println("La U aparece: " + vocal + " vez");
        } else {
            System.out.println("La U aparece: " + vocal + " veces");
        }
        s.release();
    }
}


class EjecutaVocal {
    public static void main(String[] args) {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nec euismod diam.";
        //Te dejo el ejercicio con un texto predeterminado.
        /*Scanner sc=new Scanner(System.in);
        System.out.println("Introduce una cadena de texto");
        String texto= sc.nextLine();*/
        Semaphore sem = new Semaphore(0);

        Thread a = new Thread(new Vocales_JoseASanchezLopez(texto, sem));
        Thread e = new Thread(new VocalE(texto, sem));
        Thread i = new Thread(new VocalI(texto, sem));
        Thread o = new Thread(new VocalO(texto, sem));
        Thread u = new Thread(new VocalU(texto, sem));

        a.run();
        e.run();
        i.run();
        o.run();
        u.run();
    }
}