package lesson5.calculate;

import java.util.Scanner;

public class MainCalc {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        double num1 = in.nextDouble();
        System.out.println("Введите оператор");
        char operator = in.next().charAt(0);
        System.out.println("Введите второе число");
        double num2 = in.nextDouble();


        switch (operator) {
            case '+':
                //Calculation res = new Calculation(num1, num2);
                System.out.println(new Plus().execute(num1,num2));
                break;
            case '-':
                System.out.println(new Minus().execute(num1,num2));
                break;
            case '*':
                System.out.println(new Umnog().execute(num1,num2));
                break;
            case '/':
                System.out.println(new Deli().execute(num1,num2));
                break;

        }

    }
}
