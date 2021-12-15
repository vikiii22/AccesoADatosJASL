package PSP.EstudiandoExamen;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticandoProcesBuilder {
    public static void main(String[] args) throws IOException {
        //Generar ProcessBuilder
        ProcessBuilder pb=new ProcessBuilder(args);
        Process p= pb.start();

        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));

        String linea;
        while ((linea=br.readLine())!=null){
            if (linea.contains("IPv4")){
                JOptionPane.showMessageDialog(null, linea);
            }
        }
    }
}
