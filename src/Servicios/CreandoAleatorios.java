package Servicios;

public class CreandoAleatorios {
    public static void main(String[] args) {
        int a;
        while (true){
            a=(int)(Math.random()*10);
            System.out.println(a);
            System.out.println("Aleatorio: " + a);
        }
    }
}
