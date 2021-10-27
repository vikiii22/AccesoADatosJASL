package PSP.Threads;

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