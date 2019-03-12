package lesson1.Zadanie1;

import java.util.Scanner;

public class PloshadParallelepipeda {
    public static void main(String[] args) {
        System.out.println("Задание 1. Задайте высоту, длину и ширину прямоугольного параллелепипеда и найти его площадь. Узнайте, что больше: ширина или высота и выведите информацию об этом в консоль.");
        double visota, shirina, dlina, S;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите высоту в мм: ");
        visota = in.nextDouble();
        System.out.println("Введите ширину в мм: ");
        shirina = in.nextDouble();
        System.out.println("Введите длину в мм: ");
        dlina = in.nextDouble();

        S=(visota*shirina+visota*dlina+shirina*dlina)*2;
        System.out.println("Площадь поверхности параллелепипеда = " + S+" мм2");

        String result =(visota > shirina) ? "высота больше ширины;" : "высота меньше ширины";
        System.out.println(""+ result);

    }
}

