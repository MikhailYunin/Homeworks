package lesson3;

import java.lang.reflect.Array;

public class zadanie1 {
    public static void main(String[] args) {
        int [] arr=new int[10];
        System.out.println("Задача1. Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку, \n" +
                "отделяя один элемент от другого пробелом, а затем в столбик  ");

        System.out.println("\n"+"Массив в строку: ");
        for (int i=0; i<10; i++){
            arr[i]=2*(i+1);
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n"+"\n"+"Массив в столбец:");
        for (int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}
