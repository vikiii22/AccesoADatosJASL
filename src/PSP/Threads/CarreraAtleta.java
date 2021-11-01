package PSP.Threads;

import java.util.Scanner;

public class CarreraAtleta{
    String nombre;
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

class Kilometros extends Thread {
    @Override
    public void run() {
        try {
            CarreraAtleta atleta = new CarreraAtleta();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre del Atleta: ");
            String nombre = sc.nextLine();
            atleta.setNombre(nombre);
            int i;
            for (i = 0; i <= 30; i++) {
                sleep(2500);
                System.out.println("Km " + i + " de 30");
                if (i == 30) {

                    System.out.println(atleta.nombre + " ha terminado la carrera.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ejecutaCarrera {
    public static void main(String[] args) throws InterruptedException {
        new Kilometros().start();
    }
}