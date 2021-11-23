package ru.mephi.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.*;

public class TasksAboutTime {
    public static void infoLincoln() {
        System.out.println("Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855");
        LocalDate birthday = LocalDate.of(1809, 2, 12);
        LocalDate deathday = LocalDate.of(1855, 4, 15);
        System.out.println("How old when he died? " + birthday.until(deathday, YEARS) + " years");
        System.out.println("How many days did he live? " + birthday.until(deathday, DAYS) + " days");
        System.out.println("==============================================================");
    }

    public static void infoCumberbatch() {
        System.out.println("Bennedict Cumberbatch, July 19, 1976");
        LocalDate birthday = LocalDate.of(1976, 7, 19);
        System.out.println("Born in a leap year? " + birthday.isLeapYear());
        System.out.println("How many days in the year he was born? " + birthday.lengthOfYear() + " days");
        LocalDate today = LocalDate.now();
        System.out.println("How many decades old is he? " + birthday.until(today, DECADES) + " decades");
        System.out.println("What was the day of the week on his 21st birthday? " + birthday.plusYears(21).getDayOfWeek());
        System.out.println("==============================================================");
    }

    public static void infoTrain() {
        System.out.println("Train departs Boston at 1:45PM and arrives New York 7:25PM");
        LocalTime timeBoston = LocalTime.of(13, 45);
        LocalTime timeNewYork = LocalTime.of(19, 25);
        System.out.println("How many minutes long is the train ride? " + timeBoston.until(timeNewYork, MINUTES) + " minutes");
        LocalTime actual = timeNewYork.plusHours(1).plusMinutes(19);
        System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time? " + actual);
        System.out.println("==============================================================");
    }

    public static void infoFlight() {
        System.out.println("Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes");
        LocalDateTime departure = LocalDateTime.of(2021, 3, 24, 21, 15);
        LocalDateTime arrival = departure.plusHours(4).plusMinutes(15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM hh:mma", Locale.ENGLISH);
        System.out.println("When does it arrive in Miami? " + arrival.format(formatter));
        LocalDateTime arrivalWithDelay = arrival.plusHours(4).plusMinutes(27);
        System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes? " + arrivalWithDelay.format(formatter));
        System.out.println("==============================================================");
    }

    public static void infoSchool() {
        System.out.println("School semester starts the second Tuesday of September of this year.");
        TemporalAdjuster adjuster = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY);
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), 9, 1).with(adjuster);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        System.out.println("What is the date? " + start.format(formatter));
        System.out.println("* School summer vacation starts June 25th");
        System.out.println("* Two weeks off in December");
        System.out.println("* Two other vacation weeks");
        System.out.println("* School is taught Monday - Friday");
        LocalDate summerVacation = LocalDate.of(LocalDate.now().getYear() + 1, 6, 25);
        long daysWithoutSuSa = DAYS.between(start, summerVacation) - 28;
        long duration = (daysWithoutSuSa / 7) * 5;
        System.out.println("How many days of school are there? " + duration + " days");
        System.out.println("==============================================================");
    }

    public static void infoMeeting() {
        System.out.println("A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.");
        LocalDateTime now = LocalDateTime.now();
        LocalTime schedule = LocalTime.of(13, 30);
        if (now.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
            System.out.println("What is the time of the week's meetings? Today " + schedule);
        } else if(now.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            System.out.println("What is the time of the week's meetings? Tomorrow " + schedule);
        } else {
            System.out.println("What is the time of the week's meetings? Next week, Tuesday " + schedule);
        }
        System.out.println("==============================================================");
    }

    public static void main(String[] args) {
        infoLincoln();
        infoCumberbatch();
        infoTrain();
        infoFlight();
        infoSchool();
        infoMeeting();
    }
}
