package lesson1.Zadanie6;
import java.util.Scanner;

public class NaibolshayaCifra {
    public static void main(String[] args) {
        System.out.println("Задача 6. Создать программу, выводящую в консоль наибольшую цифру любого трехзначного натурального числа.");
        int chislo, x1, x2, x3;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите трехначное натуральное число: ");
        chislo = in.nextInt();

        // далее метод костыля и палок =)
        x1=chislo/100;
        x2=(chislo-x1*100)/10;
        x3=(chislo-x1*100-x2*10);

        int result = (x1>x2) ? ( (x1>x3) ? x1 : x3) : ( (x2>x3) ? x2 : x3);
        System.out.println("Ответ: наибольшая цифра "+result);

    }


}
