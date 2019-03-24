package Kontrolnaya1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Doctor dantist = new Doctor("Стоматолог");
        Doctor surgeon = new Doctor("Хирург");
        Doctor therapist = new Doctor("Терапевт");

        Scanner in = new Scanner(System.in);




        boolean bool = false;
        while (!bool) {
            bool=true;
            System.out.println("Введите пользователя");
            String user = in.nextLine();

            switch (user) {
                case "Admin":
                    System.out.println("Вы вошли как администратор");

                    break;
                case "Главврач":
                    System.out.println("Вы вошли как главный врач");

                    break;
                case "Терапевт":
                    System.out.println("Вы вошли как терапевт");

                    break;
                case "Хирург":
                    System.out.println("Вы вошли как хирург");

                    break;
                case "Нарколог":
                    System.out.println("Вы вошли как нарколог");

                    break;
                case "Пациент":
                    Pacient pacient = new Pacient();
                    String username = pacient.getUsername();
                    Doctor doc=Admin.doctorChoise();
                    pacient.regist(username,doc);


                    break;

                default:
                    System.out.println("Вы не вошли в систему, попробуйте еще раз");
                    bool=false;

            }
        }



    }
}
