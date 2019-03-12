package lesson2.Zadanie1;

import java.util.Scanner;

public class Sortirovka {
    public static void main(String[] args) {
        System.out.println("В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа. Создать программу, которая переставит числа в переменных таким образом, чтобы при выводе на экран последовательность a, b и c оказалась строго возрастающей.");
        int a, b, c, x1, x2, D;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        a = in.nextInt();
        System.out.println("Введите второе число: ");
        b = in.nextInt();
        System.out.println("Введите третье число: ");
        c = in.nextInt();
        System.out.println("Вы ввели: " +a+ ", "+b+ ", "+c);
        if (a<b) {

            if (b<c) {
                System.out.println("возрастающая последовательность " +a+ ", " +b+ ", " +c);
            }else if (a<c) {
                System.out.println("возрастающая последовательность " +a+ ", " +c+ ", " +b);
            }else System.out.println("возрастающая последовательность " +c+ ", " +a+ ", " +b);

        }else if (b>c) {
            System.out.println("возрастающая последовательность " + c + ", " + b + ", " + a);
        } else if (c<a) {
            System.out.println("возрастающая последовательность " +b+ ", " +c+ ", " +a);
        } else
            System.out.println("возрастающая последовательность " +b+ ", " +a+ ", " +c);


    }
}
