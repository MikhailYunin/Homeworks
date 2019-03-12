package lesson1.Zadanie2;

public class DesyatSotok {
    public static void main(String[] args) {
        System.out.println("Задача 2. На садовом участке площадью 10 соток , разбили грядки 15 на 25 метров. Сколько м2 осталось незанято?");
        int S=10, a=15, b=25;
        S*=100;
        int result=S%(a*b);
        System.out.println("Ответ: не занято осталось "+ result+" m2");
    }
}
