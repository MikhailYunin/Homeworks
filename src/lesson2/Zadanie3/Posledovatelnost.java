package lesson2.Zadanie3;

public class Posledovatelnost {
    public static void main(String[] args) {
        System.out.println("Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….");
        int x=1;
        for (int i=0; i<20; i++) {
            x*=2;
            System.out.print(x+", ");
        }

    }
}
