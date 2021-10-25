package Servicios.Threads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjercicioUsuario implements Runnable{
    Thread t;
    EjercicioUsuario(){
        t=new Thread(this, "Nuevo hilo");
        t.start();
    }
    @Override
    public void run() {
        int horaEntrada=8;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nombre usuario: ");
        String usuario=sc.nextLine();
        System.out.print("Hora llegada: ");
        int horaLlegada=sc.nextInt();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yy");
        Date date=new Date();
        System.out.println("Día: " + dateFormat.format(date));

        if (horaLlegada > 24 || horaLlegada < 0){
            System.err.println("Hora fuera de rango");
            t.stop();
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

class EjecutaUsuario{
    public static void main(String[] args) {
        new EjercicioUsuario();
        System.out.println("Proceso principal");
    }
}