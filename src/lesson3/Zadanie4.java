package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args) {
        System.out.println("Пользователь должен указать с клавиатуры чётное положительное число, а программа должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку. \n" +
                "После этого программа должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше: \n" +
                "левой или правой, либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число, \n" +
                "то программа должна требовать повторного ввода до тех пор, пока не будет указано корректное значение. ");

        int j, i=0, count = 0, min = -5, max = 5, sum1=0, sum2=0;
        int diff = max - min;
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Введите количество элементов массива");
            i = in.nextInt();
        } while (i<=0);

        int[] arr = new int[i];

        System.out.println("\n" + "Массив из случайных чисел из отрезка [-5;5]: ");
        for (i = 0; i < arr.length; i++) {
            j = random.nextInt(diff + 1);
            j += min;
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n" + "половина массива");
        for (i = 0; i < arr.length/2; i++) {
            System.out.print(arr[i] + " ");
            sum1 += Math.abs(arr[i]);
        }
        System.out.println("\n" + sum1);

        System.out.println("\n" + "вторая половина массива");
        for (i = arr.length-1; i > arr.length/2; i--) {
            System.out.print(arr[i] + " ");
            sum2 += Math.abs(arr[i]);
        }
        System.out.println("\n" + sum2);

        if (sum1 > sum2){
            System.out.println("Сумма модулей чисел первой половины массива больше");
        }
        if (sum1 < sum2){
            System.out.println("Сумма модулей чисел второй половины массива больше");
        }
        if (sum1 == sum2){
            System.out.println("Сумма модулей чисел первой половины массива равна сумме модулей второй половины");
        }



    }
}
