package PSP.EstudiandoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticandoProcessBuilderII {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb=new ProcessBuilder("notepad.exe");
        Process p= pb.start();

        //BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        p.waitFor();
        System.out.println("Finalizado");
    }
}
