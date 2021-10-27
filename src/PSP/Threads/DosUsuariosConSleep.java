package PSP.Threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DosUsuariosConSleep extends Thread{
    @Override
    public void run() {
        double horaEntrada=8.00;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nombre usuario: ");
        String usuario=sc.nextLine();
        System.out.print("Hora llegada: ");
        double horaLlegada=sc.nextDouble();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yy");
        Date date=new Date();
        System.out.println("Día: " + dateFormat.format(date));

        if (horaLlegada > 23.59 || horaLlegada < 0.00){
            System.err.println("Hora fuera de rango");
            stop();
        }
        if (horaLlegada > horaEntrada){
            System.out.println(usuario + " llegas tarde");
        }else if (horaLlegada < horaEntrada){
            System.out.println(usuario + " llegas temprano");
        }else if (horaLlegada == horaEntrada){
            System.out.println(usuario + " llegas puntual");
        }
    }
}

class SegundoUsuario extends Thread{
    @Override
    public void run() {
        double horaEntrada=8.00;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nombre usuario: ");
        String usuario=sc.nextLine();
        System.out.print("Hora llegada: ");
        double horaLlegada=sc.nextDouble();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yy");
        Date date=new Date();
        System.out.println("Día: " + dateFormat.format(date));

        if (horaLlegada > 23.59 || horaLlegada < 0.00){
            System.err.println("Hora fuera de rango");
            stop();
        }
        if (horaLlegada > horaEntrada){
            System.out.println(usuario + " llegas tarde");
        }else if (horaLlegada < horaEntrada){
            System.out.println(usuario + " llegas temprano");
        }else if (horaLlegada == horaEntrada){
            System.out.println(usuario + " llegas puntual");
        }
    }
}

class EjecutandoUsuarios{
    public static void main(String[] args) throws InterruptedException {
        Thread usuario1=new Thread(new DosUsuariosConSleep());
        Thread usuario2=new Thread(new SegundoUsuario());

        usuario1.start();
        usuario1.join();
        System.out.println();
        usuario2.start();
    }
}