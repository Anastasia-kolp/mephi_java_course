package ru.mephi.hw5;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TasksAboutZone {
    public static void main(String[] args) {
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma MMMM dd, yyyy", Locale.ENGLISH);

        System.out.println("==============================================================");
        System.out.println("Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014");
        System.out.println("The flight is 5 hours 30 minutes.");
        LocalDateTime depSanFr1 = LocalDateTime.of(2014, 6, 13, 22, 30);
        ZonedDateTime departure1 = ZonedDateTime.of(depSanFr1, SFO);
        System.out.println();
        System.out.println("What is the local time in Boston when the flight takes off? " + departure1.withZoneSameInstant(BOS).format(formatter));
        ZonedDateTime arrival1 = departure1.plusHours(5).plusMinutes(30);
        System.out.println("What is the local time at Boston Logan airport when the flight arrives? " + arrival1.withZoneSameInstant(BOS).format(formatter));
        System.out.println("What is the local time in San Francisco when the flight arrives? " + arrival1.format(formatter));
        System.out.println("==============================================================");

        System.out.println("Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014");
        System.out.println("The flight time is 22 hours.");
        LocalDateTime depSanFr2 = LocalDateTime.of(2014, 6, 28, 22, 30);
        ZonedDateTime departure2 = ZonedDateTime.of(depSanFr2, SFO);
        LocalDateTime meeting = LocalDateTime.of(depSanFr2.getYear(), depSanFr2.getMonth(), depSanFr2.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).getDayOfMonth(), 9, 0);
        ZonedDateTime meetingBLR = ZonedDateTime.of(meeting, BLR);
        ZonedDateTime arrival2 = departure2.plusHours(22);
        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time? " + arrival2.withZoneSameInstant(BLR).isBefore(meetingBLR));
        System.out.println("Can the traveler call her husband at a reasonable time when she arrives?");
        System.out.println("Her local time: " + arrival2.withZoneSameInstant(BLR).format(formatter));
        System.out.println("His local time: " + arrival2.format(formatter));
        System.out.println("==============================================================");

        System.out.println("Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014");
        System.out.println("Flight time is 5 hours 30 minutes.");
        LocalDateTime depSanFr3 = LocalDateTime.of(2014, 11, 1, 22, 30);
        ZonedDateTime departure3 = ZonedDateTime.of(depSanFr3, SFO);
        ZonedDateTime arrival3 = departure3.plusHours(5).plusMinutes(30);
        System.out.println("What day and time does the flight arrive in Boston? " + arrival3.withZoneSameInstant(BOS).format(formatter) + ", " + arrival3.withZoneSameInstant(BOS).getDayOfWeek());
        System.out.println("==============================================================");
    }
}
