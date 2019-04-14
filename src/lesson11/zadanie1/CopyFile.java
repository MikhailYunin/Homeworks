package lesson11.zadanie1;

//Задача 1
//        Скопировать файл (имена файлов задаются с клавиатуры). Программа должна выводить количество скопированных байт


import java.io.*;
import java.nio.charset.Charset;

public class CopyFile {


    public static void main(String[] args) {


        try {
            copyFile(new FileInputStream("src/lesson11/zadanie1/oldfile.txt"), new FileOutputStream("src/lesson11/zadanie1/newfile.txt"), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public static void copyFile(InputStream input, OutputStream output, Charset charset) throws IOException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(input);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output)

        ) {
            //File newFile = new File("copyFile")
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[3];
            int len;
            while ((len = inputStreamReader.read(buf)) > 0) {
                sb.append(buf, 0, len);

            }
            System.out.println(sb.toString());
            outputStreamWriter.write(sb.toString());

        }


    }

}
