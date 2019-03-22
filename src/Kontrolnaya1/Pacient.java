package Kontrolnaya1;

import java.lang.reflect.Array;
import java.util.Objects;

public class Pacient {
    private String login;

    public Pacient(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pacient)) return false;
        Pacient pacient = (Pacient) o;
        return Objects.equals(login, pacient.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }






    }

}

