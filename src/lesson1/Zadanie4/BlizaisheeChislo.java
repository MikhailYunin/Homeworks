package lesson1.Zadanie4;

import java.util.Scanner;

public class BlizaisheeChislo {
    public static void main(String[] args) {
        System.out.println("Задача 4. Вывести в консоль ближайшее к 10 из двух чисел, записанных в переменные m и n");
        int z=10;
        double m, n, var1, var2;
        // пока не ясно как пользоваться System.in.read()

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        m = in.nextDouble();
        System.out.println("Введите второе число: ");
        n = in.nextDouble();

        //m=8.5;
        //n=11.45;

        var1=Math.abs(m-z);
        var2=Math.abs(n-z);

        //System.out.println(var2);
        //при модель числа получается (выражения 10-11.45) = 1.4499999999999993, а не 1,45. Почему??

        double result = (var1 < var2) ? m : n;
        System.out.println("Ответ: ближайшее число к десяти : " + result);
    }
}
