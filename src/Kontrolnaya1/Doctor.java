package Kontrolnaya1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Doctor {
    public String specialty;
    public String [][][][] zapis = new String[99][12][31][20];

    public Doctor() {
    }

    public Doctor(String specialty) {
        this.specialty = specialty;
    }
}
