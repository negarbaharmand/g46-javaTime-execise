package com.baharmand;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        //Ex.1
        LocalDate todayDate = LocalDate.now();
        System.out.println("Today's date is " + todayDate + ".");

        //Ex.2
        LocalDateTime todayDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM", new Locale("sv", "SE"));
        String formattedDate = todayDateTime.format(formatter);

        System.out.println("Idag är den " + formattedDate + ".");
        //Ex.3
        LocalDate lastMonday = todayDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println("Last Monday was: " + lastMonday);

        for (int i = 0; i < 7; i++){
            LocalDate weekDay = lastMonday.plusDays(i);

            System.out.println(weekDay.format(DateTimeFormatter.ISO_WEEK_DATE));
        }

        //Ex.4
        LocalDate myBirthDate = LocalDate.parse("1990-10-17");
        System.out.println("My birth date is " +myBirthDate);

        //Ex.5
        System.out.println("This day was a " + LocalDate.of(1945, 5, 8).getDayOfWeek() + ".");

        //Ex6.
        LocalDate modifiedDate = LocalDate.now().plusYears(10).minusMonths(10);
        System.out.println("Month: " + modifiedDate.getMonth());

        //E7.
        LocalDate birthdate = LocalDate.of(1990, 10, 17);
        Period period = Period.between(birthdate, modifiedDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("Elapsed Years: " + years);
        System.out.println("Elapsed Months: " + months);
        System.out.println("Elapsed Days: " + days);

    }
}
