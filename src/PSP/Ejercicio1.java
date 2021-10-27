package PSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        String comando="ipconfig";
        String line;
        Process p=null;
        InputStream is;
        BufferedReader bf;

        try {
            p=Runtime.getRuntime().exec(comando);
            is=p.getInputStream();
            bf=new BufferedReader(new InputStreamReader(is));
            while ((line = bf.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Otra opción
         *try {
            Process process=Runtime.getRuntime().exec("cmd /c ipconfig");
            BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String result=null;
            while ((result = br.readLine())!=null){
                System.out.println(result);
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /*if (args.length <= 0){
            System.err.println("Se necesita un argumento.");
            System.exit(-1);
        }
        Runtime runtime=Runtime.getRuntime();
        try {
            Process process=runtime.exec(args);
            System.out.println("Ejecutado");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
