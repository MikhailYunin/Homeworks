package lesson3;

import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) {
        System.out.println("1) Найти в строке указанную подстроку и заменить ее на новую. \n" +
                "Строку, ее подстроку для замены и новую подстроку вводит пользователь. ");

        String oldString;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку ");
        oldString = in.nextLine();
 //       System.out.println(oldString.trim()); //не удаляет
        System.out.println(oldString.replaceAll("\\s",""));
    }
}
