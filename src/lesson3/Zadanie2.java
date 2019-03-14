package lesson3;

public class Zadanie2 {
    public static void main(String[] args) {
        System.out.println("Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, \n" +
                "а затем этот же массив выведите на экран тоже в строку, \n" +
                "но в обратном порядке");
        int j=1;
        int [] arr=new int[50];

        System.out.println("\n"+"Массив в прямом порядке: ");
        for (int i=0; i<arr.length; i++) {
            arr[i] = j;
            j+=2;
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n"+"Массив в обратном порядке: ");
        for (int i=49; i>=0; i--) {
            System.out.print(arr[i] + " ");
        }

    }
}
