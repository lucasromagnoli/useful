package br.com.lucasromagnoli.javaee.useful.support.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateSupport {
    private DateSupport() {};
    
    public static LocalDate convertFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
    
}
