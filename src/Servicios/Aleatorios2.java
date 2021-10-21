package Servicios;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Aleatorios2 {
    public static void main(String[] args) {
        ProcessBuilder pb=new ProcessBuilder();
        pb.command("java","-cp","D:\\Documents\\2DAM\\AccesoADatos\\ProyectoDatos\\out\\production\\AccesoADatosJASL\\Servicios","CreandoAleatorios");
        String line="";
        try {
            Process p = pb.start();

            BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintStream ps=new PrintStream(p.getOutputStream());
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

            while ((!in.readLine().equals("fin"))){
                ps.println();
                if ((line=br.readLine())!=null){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
