package lesson11.zadanie2;

import java.io.*;
import java.nio.charset.Charset;

public class cropFile {

//OutputStream output1,

    public static void main(String[] args) {

// разрезать файл
      /*  try {
            toCrop(new FileInputStream("src/lesson11/zadanie2/oldfile.txt"),
                    new FileOutputStream("src/lesson11/zadanie2/newfile1.txt"),
                    new FileOutputStream("src/lesson11/zadanie2/newfile2.txt"),20);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/



        File[] files = {
                new File("src/lesson11/zadanie2/newfile1.txt"),
                new File("src/lesson11/zadanie2/newfile2.txt")
        };

        try {
            pasteTogether(files,new FileOutputStream("src/lesson11/zadanie2/pasteTogether.txt"),Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    public static void toCrop(InputStream input, OutputStream output1, OutputStream output2, int crop) throws IOException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(input);
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(output1);
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(output2)


        ) {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[20];
            int len;
            while ((len = inputStreamReader.read(buf)) > 0) {
                sb.append(buf, 0, len);
            }

            String string1 = sb.toString();
            sb.delete(0,sb.length());//очистка

            for (int i = 0; i < crop; i++) {
                sb.append(string1.charAt(i));
            }
            outputStreamWriter1.write(sb.toString());

            sb.delete(0,sb.length());//очистка

            for (int i = crop; i < string1.length(); i++) {
                sb.append(string1.charAt(i));
            }
            outputStreamWriter2.write(sb.toString());

        }
    }


    public static void pasteTogether (File[] files,OutputStream output, Charset charset) throws IOException {
        try (
                InputStream inputStream1 = new FileInputStream(files[0]);
                InputStream inputStream2 = new FileInputStream(files[1]);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output);
                ByteArrayOutputStream bout = new ByteArrayOutputStream()



        ) {

            SequenceInputStream sequenceInputStream =
                    new SequenceInputStream(inputStream1, inputStream2);
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[20];
            int len;
            while ((len = sequenceInputStream.read(buf)) > 0) {
                bout.write(buf, 0, len);
            }


            outputStreamWriter.write(new String(bout.toByteArray(),charset));

        }
    }

}
