package PSP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Process> p = new ArrayList<>();
        int i = 0, fin = 0;
        Process process = null;

        if (args.length < 1) {
            System.err.println("Número de parámtros incorrecto");
        } else {
            fin = args.length;
            try {
                while (i < fin) {
                    process = Runtime.getRuntime().exec(args[i]);
                    i++;
                    p.add(process);
                }
                for (int j=0; j<p.size();j++){
                    System.out.println("Desea eliminar el proceso "+j+"?");
                    String elegido=sc.nextLine();
                    if (elegido.equals("si")){
                        if (j==0){
                            process.destroy();
                        }if (j==1){
                            process.destroy();
                        }
                    }
                }
                int res = process.waitFor();
                System.out.println("Aplicaciones finalizadas");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }








        /*System.out.print("Introduce un parámetro: ");
        Scanner sc = new Scanner(System.in);
        String comando = sc.nextLine();
        String line;
        Process p = null;
        InputStream is;
        BufferedReader bf;

        try {
            if (comando.isEmpty()) {
                System.err.println("No puede estar vacío");
                System.exit(-1);
            }
            p = Runtime.getRuntime().exec(comando);
            is = p.getInputStream();
            bf = new BufferedReader(new InputStreamReader(is));
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-----------------------");
            System.out.println("Aplicación finalizada");
        } catch (IOException e) {
            System.err.println("Parámetro mal introducido");
        }*/
    }
}