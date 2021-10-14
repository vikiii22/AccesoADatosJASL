package Ejercicio14;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONReader {
    public static String readUsers(String url) throws IOException {
        InputStream inputStream = new URL(url).openStream();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
            int cp;
            while ((cp=bfr.read())!=-1){
                stringBuilder.append((char) cp);
            }
            bfr.close();
        }finally {
            inputStream.close();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readUsers("https://jsonplaceholder.typicode.com/users"));
    }
}