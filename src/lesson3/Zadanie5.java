package lesson3;

import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args) {
        System.out.println("1) Найти в строке указанную подстроку и заменить ее на новую. \n" +
                "Строку, ее подстроку для замены и новую подстроку вводит пользователь. ");

        String oldString;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку ");
        oldString = in.nextLine();

        String oldUpString;
        System.out.println("Введите подстроку, которую требуется заменить ");
        oldUpString = in.nextLine();

        String newUpString;
        System.out.println("Введите подстроку, которую требуется заменить ");
        newUpString = in.nextLine();

        String newString =  oldString.replace(oldUpString , newUpString);
        System.out.println(newString);
    }
}
