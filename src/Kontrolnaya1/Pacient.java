package Kontrolnaya1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pacient {
    public String username;
    Scanner in = new Scanner(System.in);

    public Pacient() {
        System.out.println("Введите Ваше имя пользователя");
        String username = in.nextLine();
        this.username = username;
        Admin.login(this.username);
//        System.out.println(Arrays.toString(Bolnica.spisokPacientov));
    }

    public void regist (String username, Doctor doc) {
        Admin.registratura(username, doc);
    }

    public String getUsername() {
        return username;
    }

}

