package Kontrolnaya1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("Введите пользователя");
        String user = in.nextLine();

        switch (user){
            case "Admin":
                System.out.println("Вы вошли как администратор");
            case "Главврач":
                System.out.println("Вы вошли как главный врач");
            case "Терапевт":
                System.out.println("Вы вошли как терапевт");
            case "Хирург":
                System.out.println("Вы вошли как хирург");
            case "Нарколог":
                System.out.println("Вы вошли как нарколог");
            case "Пациент":
                System.out.println("Введите Ваш логин");
                String login2 = in.nextLine();
                Pacient nextPacient = new Pacient(login2);
                nextPacient.logname("login2");

               // Pacient.logname(in.nextLine());
               // Pacient.logname(in.nextLine());
                default:
                    System.out.println("Вы не вошли в систему, попробуйте еще раз");
        }




    }
}
