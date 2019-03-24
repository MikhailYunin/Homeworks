package Kontrolnaya1;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Admin {



    public static void login(String login) {
        boolean bool = false;
        Bolnica spisok = new Bolnica();

        spisok.spisokPacientov[0]="Иван";
        spisok.spisokPacientov[1]="Владимир";

        for (int i = 0; i < 20; i++) {
            if (spisok.spisokPacientov[i] !=null){
                bool = login.equals(spisok.spisokPacientov[i]);
                if (bool) break;
            }
        }
        if (bool) {
            System.out.println("Вы вошли как пользователь " + login);
        } else for (int i = 0; i < 20; i++) {
            if (spisok.spisokPacientov[i] == null) {
                spisok.spisokPacientov[i] = login;
                break;
            }
        }

    }

    public static Doctor doctorChoise (){
        Doctor doc = new Doctor();

        boolean bool = false;
        while (!bool) {
            try {
                System.out.println("Выберете врача и введите его номер:\n" +
                        "1. Стоматолог\n" +
                        "2. Хирург\n" +
                        "3. Терапевт ");
                Scanner sc = new Scanner(System.in);
                int docID = sc.nextInt();

                switch (docID){
                    case 1:
                        Doctor dantist = new Doctor("Стоматолог");
                        doc = dantist;
                        System.out.println("Вы выбрали стоматолога");
                        bool = true;
                        break;

                    case 2:
                        Doctor surgeon = new Doctor("Хирург");
                        doc = surgeon;
                        System.out.println("Вы выбрали хирурга");
                        bool = true;
                        break;

                    case 3:
                        Doctor therapist = new Doctor("Терапевт");
                        doc = therapist;
                        System.out.println("Вы выбрали терапевта");
                        bool = true;
                        break;

                        default:
                            System.out.println("Некоректный ввод");


                }

            } catch (InputMismatchException e) {
                System.out.println("Некоректный ввод");
                bool = false;
            }


        }
        return doc;
    }


    public static void registratura (String login, Doctor doc) {
        Scanner sc = new Scanner(System.in); // дата введенная с клавиатуры
        Calendar currentDate = Calendar.getInstance(); // инициализация текущей даты
        Calendar dataIn = new GregorianCalendar(); // инициализация переменной для даты введенной с клавиатуры

        boolean done = false;
        while (!done) {
            try {
                System.out.println("Для записи к "+doc.specialty+ "у введите желаемую дату и время в формате:   ГГ.ММ.ДД ЧЧ:ММ  ");
                String dateString = sc.nextLine();
                SimpleDateFormat formatDate = new SimpleDateFormat("yy.MM.dd k:mm");
                dataIn.setTime(formatDate.parse(dateString));
                if (currentDate.getTime().before(dataIn.getTime())){
                    if (dataIn.get(Calendar.DAY_OF_WEEK)<6){
                        if (dataIn.get(Calendar.HOUR_OF_DAY)>7 & dataIn.get(Calendar.HOUR_OF_DAY)<20 ){
                            if (doc.zapis[dataIn.get(Calendar.YEAR) % 100][dataIn.get(Calendar.MONTH)][dataIn.get(Calendar.DAY_OF_MONTH)][dataIn.get(Calendar.HOUR_OF_DAY)] == null) {
                                doc.zapis[dataIn.get(Calendar.YEAR) % 100][dataIn.get(Calendar.MONTH)][dataIn.get(Calendar.DAY_OF_MONTH)][dataIn.get(Calendar.HOUR_OF_DAY)] = login;
                               // System.out.println(doc.zapis[dataIn.get(Calendar.YEAR) % 100][dataIn.get(Calendar.MONTH)][dataIn.get(Calendar.DAY_OF_MONTH)][dataIn.get(Calendar.HOUR_OF_DAY)]);
                                System.out.println("Поздравляю, Вы записаны к "+doc.specialty+"у");

                                done = true;
                            }else System.out.println("Данное время занятно, попробуйте другое время");
                        }else System.out.println("Вы ввели нерабочие чаты");
                    } else System.out.println("Вы выбрали выходной день");

                } else System.out.println("Вы ввели дату из прошлого");
                System.out.println();

            } catch (ParseException e) {
                System.out.println("Неправильно введена дата!!!");

            }
        }
    }



}