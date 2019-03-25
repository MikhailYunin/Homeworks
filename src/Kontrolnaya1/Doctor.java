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

    public void prosmotrZapisei (Doctor doc, int month, int day) {

        Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR)%100;
        System.out.println("к "+doc.specialty+"у записаны на дату "+day+"."+month);
        for (int i=8; i<20; i++){
            System.out.println(""+i+":00 - " +doc.zapis [year][month][day][i]);
        }

    }
}
