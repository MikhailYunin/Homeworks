package lesson1.Zadanie5;

import java.util.Scanner;

public class KvadratnoeUravnenie {
    public static void main(String[] args) {
        System.out.println("Задача 5. В три переменные a, b и c записаны три вещественных числа. Создать программу, которая будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0, либо сообщать, что корней нет.");
        double a, b, c, x1, x2, D;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите коэффициент а: ");
        a = in.nextDouble();
        System.out.println("Введите коэффициент b: ");
        b = in.nextDouble();
        System.out.println("Введите коэффициент c: ");
        c = in.nextDouble();

        System.out.println("Уравнение имеет вид:" +a+"x*x+"+b+"x+"+c);

        D = b*b-4*a*c;
        if (D > 0) {
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Ответ: первый корень уравнения : "+x1+", второй корень уравнения : "+x2 );
        }
        else {
            if (D == 0) {
                x1 = -b / 2 * a;
                System.out.println("Ответ: корень уравнения : " + x1);
            }
            else System.out.println("Ответ: корней уравнения нет ");
        }
    }
}
