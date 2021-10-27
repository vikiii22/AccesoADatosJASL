package PSP;

import java.io.IOException;
import java.util.Scanner;

public class Aleatorios {
    public static void main(String[] args) throws IOException {
        Process p = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce algo");
        String entrada = sc.nextLine();

        int num = (int) (1 + Math.random() * 10);
        System.out.println(num);



        while (!entrada.equals("fin")) {
            System.out.println("Introduce algo");
            entrada = sc.nextLine();
            num = (int) (1 + Math.random() * 10);
            if (entrada.equals("fin")) {
                break;
            } else {
                System.out.println(num);
            }
        }
    }
}
