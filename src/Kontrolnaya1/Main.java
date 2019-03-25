package Kontrolnaya1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Doctor dantist = new Doctor("Стоматолог");
        Doctor surgeon = new Doctor("Хирург");
        Doctor therapist = new Doctor("Терапевт");

        Scanner in = new Scanner(System.in);




        boolean bool = false;

    outer: while (!bool) {
            bool=true;
            System.out.println("Введите пользователя: Admin, Главврач, Терапевт, Хирург, Стоматолог или Пациент");
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
                case "Стоматолог":
                    System.out.println("Вы вошли как стоматолог");

                    System.out.println("для простмотра записей введите требуемый месяц");
                    int month = in.nextInt();
                    System.out.println("введите день месяца");
                    int day = in.nextInt();

                    System.out.println("");
                    dantist.prosmotrZapisei(dantist,month,day);

                    break;
                case "Пациент":
                    Pacient pacient = new Pacient();
                    String username = pacient.getUsername();
                    Doctor doc=Admin.doctorChoise();
                    pacient.regist(username,doc);

                    System.out.println("Для выхода введите Exit");
                    if (in.nextLine() == "Exit"){
                        break outer;
                    }

   //                 break;

                default:
                    System.out.println("Вы не вошли в систему");
                    bool=false;

            }
        }



    }
}
