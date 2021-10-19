package Servicios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class probandoThread {
    static ProcessBuilder pb = new ProcessBuilder();

    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce algo");
        String intro = sc.nextLine();
        int num = (int) (1 + Math.random() * 10);
        System.out.println(num);

        while (!intro.equals("fin")) {
            System.out.println("Introduce algo");
            intro = sc.nextLine();
            num = (int) (1 + Math.random() * 10);
            if (intro.equals("fin")) {
                break;
            } else {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Runnable run=new Runnable() {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce algo");
                String intro = sc.nextLine();
                int num = (int) (1 + Math.random() * 10);
                System.out.println(num);

                while (!intro.equals("fin")) {
                    System.out.println("Introduce algo");
                    intro = sc.nextLine();
                    num = (int) (1 + Math.random() * 10);
                    if (intro.equals("fin")) {
                        break;
                    } else {
                        System.out.println(num);
                    }
                }
            }
        };
        Thread t=new Thread(run);
        t.start();
        System.out.println(t.getName());
    }

}
