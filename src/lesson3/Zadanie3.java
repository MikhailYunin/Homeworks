package lesson3;

import java.util.Random;

public class Zadanie3 {
    public static void main(String[] args) {
        System.out.println("Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран. \n" +
                "Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке. ");

        int j, count = 0, min = 0, max = 9;

        int diff = max - min;
        Random random = new Random();
        int[] arr = new int[15];

        System.out.println("\n" + "Массив из 15 случайных целых чисел из отрезка [0;9]: ");
        for (int i = 0; i < arr.length; i++) {
            j = random.nextInt(diff + 1);
            j += min;
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i] % 2;
            if (x == 0 & arr[i] != 0) {
                count++;
            }
        }
        System.out.println("\n" + "Количество четных элементов массива? " + count);
    }
}
