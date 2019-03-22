package Kontrolnaya1;

public class Bolnica {

    private String[] spisokPacientov = new String[20];



    public void logname(String login) {
        boolean bool = false;
        for (int i = 0; i < 20; i++) {
            bool = spisokPacientov[i].equals(login);
        }
        if (bool) {
            System.out.println("Вы вошли как пользователь" + login);
        } else for (int i = 0; i < 20; i++) {
            if (spisokPacientov[i] == null) {
                spisokPacientov[i] = login;
            }
        }

    }
}
