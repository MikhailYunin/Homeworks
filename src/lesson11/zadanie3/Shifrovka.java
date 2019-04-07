package lesson11.zadanie3;

//Задача 3
//        a) Зашифровать/ дешифровать файл паролем (XOR) (посмотреть в интернете)
//        b) Зашифровать/ дешифровать файл другим файлом


import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Shifrovka {

    public static void main(String[] args) {
        String pKey = "KeyOf";
        String pText;
        String shifrText;



        File file = new File("src/lesson11/zadanie3/file.txt");
        File file2 = new File("src/lesson11/zadanie3/file2.txt");
        File file3 = new File("src/lesson11/zadanie3/pKey.txt");
        File file4 = new File("src/lesson11/zadanie3/file4.txt");


        try (FileOutputStream outputStream = new FileOutputStream("src/lesson11/zadanie3/file2.txt", false);
             FileOutputStream outputStream2 = new FileOutputStream("src/lesson11/zadanie3/file3.txt", false);
             FileOutputStream outputStream3 = new FileOutputStream("src/lesson11/zadanie3/file4.txt", false);
             FileOutputStream outputStream4 = new FileOutputStream("src/lesson11/zadanie3/file5.txt", false)
        ){

 //        a) Зашифровать/ дешифровать файл паролем (XOR)
            pText = readByteArray(file, Charset.forName("UTF-8"));
            //System.out.println(pText);
            byte[] res = encode(pText, pKey);
            outputStream.write(res);

            shifrText = readByteArray(file2, Charset.forName("UTF-8"));
            byte[] decode = decode(shifrText,pKey);
            outputStream2.write(decode);

//b) Зашифровать/ дешифровать файл другим файлом

            String filepKey = readByteArray(file3, Charset.forName("UTF-8"));
            byte[] res2 = encode(pText, filepKey);
            //writeToFile("src/file.txt",);
            outputStream3.write(res2);

            String shifrText2 = readByteArray(file4, Charset.forName("UTF-8"));
            byte[] decode2 = decode(shifrText2,filepKey);
            outputStream4.write(decode2);



        } catch (IOException e) {
            e.printStackTrace();

        }



    }

    public static byte[] decode(String input, String pKey) {
        byte[] pText = input.getBytes();
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return res;
    }

    public static byte[] encode(String pText, String pKey) {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }

    public static String readByteArray(File file, Charset charset) throws IOException {

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ) {


            byte[] buf = new byte[1024];

            int len;

            while ((len = fileInputStream.read(buf)) > 0) {
                //System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, len);
            }
            //System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
           // System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
            return new String(byteArrayOutputStream.toByteArray(), charset);
        }

    }





}
