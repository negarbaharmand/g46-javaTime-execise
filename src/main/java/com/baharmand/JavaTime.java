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

        //E8.
        Period customPeriod = Period.of(4, 7, 29);
        System.out.println(todayDate.plus(customPeriod));

        //E9.
        LocalTime currentTime = LocalTime.now();

        //E10.
        System.out.println("Current time is " + currentTime.getNano() + " nano seconds.");

        //E11.
        LocalTime sleepTime = LocalTime.parse("21:59:59");

        //E12.
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println("Sleep time is " + sleepTime.format(timeFormatter) + ".");

        //E13.
        LocalDateTime dateTime= LocalDateTime.of(2018, 4, 5, 10, 0);
        System.out.println(dateTime);

        //E14.
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("eeee dd MM y 'T' hh:mm:ss", new Locale("sv", "SE"));
        System.out.println(dateTime.format(dateTimeFormat));

        //E15.
        LocalDate date = LocalDate.of(2023, 7, 4);
        LocalTime time = LocalTime.of(14, 30);

        System.out.println("LocalDateTime: " + date.atTime(time));

        //E16.
        LocalDateTime dateeTimee = LocalDateTime.of(2023, 7, 4, 14, 30);

        LocalDate datee = dateTime.toLocalDate();
        LocalTime timee = dateTime.toLocalTime();

        System.out.println("LocalDate: " + datee);
        System.out.println("LocalTime: " + timee);

    }
}
