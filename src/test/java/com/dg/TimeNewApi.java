package com.dg;

import org.junit.Test;

import java.time.*;

public class TimeNewApi {

    @Test
    public void testNow(){
        final LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: "+localDate);

        final LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: "+localTime);

        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: "+localDateTime);
    }

    @Test
    public void testOf(){
        final LocalDate localDate = LocalDate.of(2016, 12, 01);
        System.out.println("LocalDate: "+localDate);

        final LocalTime localTime = LocalTime.of(23, 12, 56, 234);
        System.out.println("LocalTime: "+localTime);


        final LocalDateTime localDateTime = LocalDateTime.of(2016, 12, 01, 23, 12, 56, 234);
        System.out.println("LocalDateTime: "+localDateTime);
    }


    @Test
    public void testPlusMinusTimeUnits(){
        System.out.println("Today: "+LocalDate.now());
        final LocalDate todayPlus10Days = LocalDate.now().plusDays(10);
        System.out.println("localDatePlus10: "+todayPlus10Days);

        System.out.println("Time Now: "+LocalTime.now());
        LocalTime nowMinus20Minutes=LocalTime.now().minusMinutes(20);
        System.out.println("nowMinus20Minutes: "+nowMinus20Minutes);

        System.out.println("Date-Time Now: "+LocalDateTime.now());
        LocalDateTime nowPlus2Years =LocalDateTime.now().plusYears(2);
        System.out.println("todayPlus2Years: "+nowPlus2Years);
    }

    @Test
    public void testWithTimeUnits(){
        System.out.println("Today: "+LocalDate.now());
        LocalDate dayOfMonth20=LocalDate.now().withDayOfMonth(20);
        System.out.println("Day of month set as 20: "+dayOfMonth20);

        System.out.println("Time Now: "+LocalTime.now());
        LocalTime minute0=LocalTime.now().withMinute(0);
        System.out.println("Minutes set to 0: "+minute0);

        System.out.println("Date-Time Now: "+LocalDateTime.now());
        LocalDateTime month10 =LocalDateTime.now().withMonth(10);
        System.out.println("Month set to 10: "+month10);
    }

    @Test
    public void testGetTimeUnits(){
        System.out.println("Today: "+LocalDate.now());
        int dayOfMonth=LocalDate.now().getDayOfMonth();
        System.out.println("Day of month is: "+dayOfMonth);

        System.out.println("Time Now: "+LocalTime.now());
        int minute=LocalTime.now().getMinute();
        System.out.println("Minutes value is: "+minute);

        System.out.println("Date-Time Now: "+LocalDateTime.now());
        Month month = LocalDateTime.now().getMonth();
        System.out.println("Month value is: "+month.getValue());
    }

    @Test
    public void testFirstWorkingDay(){
        final LocalDate localDate = LocalDate.of(2016, 01, 01);
        final DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(localDate+" was a "+dayOfWeek);
        LocalDate firstWorkingDay;

        switch (dayOfWeek){
            case FRIDAY: firstWorkingDay = localDate.plusDays(3);
                            break;
            case SATURDAY: firstWorkingDay = localDate.plusDays(2);
                        break;
            default: firstWorkingDay = localDate.plusDays(1);
                        break;
        }
        System.out.println("First working day of 2016 was "+firstWorkingDay);
    }

}
