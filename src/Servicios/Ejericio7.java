package Servicios;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejericio7 {
    public static void main(String[] args) {
        String comando="ipconfig";
        String linea;
        Process p=null;
        InputStream inputStream;
        BufferedReader bufferedReader;

        try {
            p=Runtime.getRuntime().exec(comando);
            inputStream=p.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            while ((linea = bufferedReader.readLine()) != null){
                if (linea.contains("IPv4")){
                    JOptionPane.showMessageDialog(null, linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
