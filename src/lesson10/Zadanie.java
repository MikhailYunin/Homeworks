package lesson10;
/*
Домашнее задание:
        1. Сосчитать частоту встречаемости слов в War and peace (файл wp.txt).
        2. Собрать все слова в группы по количеству букв: например, в одну группу попадут слова: [the, war, jar, get, met...], в другую [on, up, no, of...].
        3. Вывести топ 10 самых частых слов и фраз.
        4. Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).
        5. Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы.*/


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Zadanie {

    public static void main(String[] args) {




        String str = null;
        try {
            str = readByteArray(new File("src/lesson10/wp.txt"), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        str = str.toLowerCase();
        str = str.replaceAll("\\W", " ");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("  ", " ");
        //System.out.println(str);
        String str2[] = str.split(" ");
        System.out.println(Arrays.toString(str2));
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s: str2){
            if (hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s)+1);
            }else hashMap.put(s,1);
        }




/*        LinkedList<String> list = new LinkedList();
       HashMap<Integer, List<String>> hashMap2 = new HashMap<>();

        for (String s: str2){


                hashMap2.put(s.length(), list.addLast(s));

        }
        LinkedList<String> list = new LinkedList();
        list.


        System.out.println(hashMap2.toString());

        System.out.println(hashMap2.get(1));*/





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
