import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejemploProcesos {
    public static void main(String[] args) {
        try {
            Process process=Runtime.getRuntime().exec("cmd /c ipconfig");
            BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String result=null;
            while ((result = br.readLine())!=null){
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
