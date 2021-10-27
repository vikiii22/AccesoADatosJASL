package PSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {
    public static void main(String[] args) throws IOException {
        Process p;
        try {
            p = Runtime.getRuntime().exec(args);
            p.waitFor();
            System.out.println("La aplicación se ha cerrado y ejectuado correctamente");


            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            System.out.println("Buscando error con: " + Arrays.toString(args));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
