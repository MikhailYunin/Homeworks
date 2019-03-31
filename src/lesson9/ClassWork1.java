package lesson9;

import lesson4.zadanie1.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ClassWork1 {
    public static void main(String[] args) {
        System.out.println("Задача 1\n" +
                                "Написать программу со следующим функционалом:\n" +
                                "Считывание максимум 5 строк с клавиатуры, \n" +
                                "занесение строк в список,\n" +
                                "поиск самой короткой строки,\n" +
                                "вывод самой короткой строки на экран по запросу пользователя (команда в консоле /short string)");
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> minList = new ArrayList<String>();
        for (int i=0; i<5; i++){
            System.out.println("ВВедите текст");
            String str = in.nextLine();
            list.add(i, str);
        }
        int minLength = list.get(0).length();
        for (int i=1; i<list.size(); i++){
            if (list.get(i).length() < minLength){
                minLength = list.get(i).length();
            }
        }
        for (int i=0; i<5; i++){
            if (list.get(i).length() == minLength) {
                minList.add(list.get(i));
            }
        }


        System.out.println("Если требуется вывести самые короткие строки, введите команду - short string ");
        String command = in.nextLine();
        if (command.equals("short string")){
            System.out.println("Самые короткие строки:");
            for (String str: minList){
                System.out.println(str);
            }
        }


    }
}


