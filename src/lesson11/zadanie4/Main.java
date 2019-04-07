package lesson11.zadanie4;

//Посчитать в файле количество символов , (запятая). Количество вывести в консоль.

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {

        try {
            countChar(new FileInputStream("src/lesson11/zadanie4/file.txt"), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void countChar(InputStream input, Charset charset) throws IOException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(input);

        ) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char[] buf = new char[1];
            int len;
            while ((len = inputStreamReader.read(buf)) > 0) {
                sb.append(buf, 0, len);
            }

            for (int i=0; i<sb.length(); i++)
            { if (sb.charAt(i) == ',')
                count++;
            }
            System.out.println(count);

        }


    }
}
