package lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        System.out.println("Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы. \n" +
                "Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив. ");


        String oldString;
        int i;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку ");
        oldString = in.nextLine();
        String numberOnly= oldString.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
        System.out.println(numberOnly.length());
        int [] arr=new int[numberOnly.length()];
        System.out.println(Arrays.toString(arr));



//        StringBuffer stringBuff = new StringBuffer(oldString);
//        StringBuilder builder = new StringBuilder();

//        numberOnly.split("");
//        System.out.println(Arrays.toString(numberOnly.split("")));


       for (i=0; i<numberOnly.length(); i++) {
           arr[i]=Integer.parseInt(numberOnly.substring(i));
           System.out.println(numberOnly.substring(i)); // не извлекает элемент

      }
        System.out.println(Arrays.toString(arr));


    }
}
