package ru.open.birthday.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

    public static Integer getCountDayCurrentYear() {
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        return cal.isLeapYear(Calendar.getInstance().get(Calendar.YEAR)) ? 366 : 365;
    }

    public static Long getDaysBeforeBirthday(Date birthdayDate){
        LocalDate today = LocalDate.now();
        LocalDate birthday = birthdayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        Period p = Period.between(birthday, today);
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        LocalDate birthdayInCurrentYear = null;

        if (birthday.getMonth().getValue() == 2 && birthday.getDayOfMonth() == 29 && !cal.isLeapYear(p.getYears() + 1 + birthday.getYear())){
            birthdayInCurrentYear = LocalDate.of(p.getYears() + 1 + birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth() - 1);
        }else {
            birthdayInCurrentYear = LocalDate.of(p.getYears() + 1 + birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth());
        }

        Calendar todayCal = Calendar.getInstance();
        Calendar birthdayInCurrentYearCal = Calendar.getInstance();
        birthdayInCurrentYearCal.set(birthdayInCurrentYear.getYear(), birthdayInCurrentYear.getMonthValue() - 1, birthdayInCurrentYear.getDayOfMonth());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return (birthdayInCurrentYearCal.getTimeInMillis() - todayCal.getTimeInMillis())/1000/60/60/24;
    }
    
}
