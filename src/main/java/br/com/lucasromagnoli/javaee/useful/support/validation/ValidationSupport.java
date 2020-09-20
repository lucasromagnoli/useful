package br.com.lucasromagnoli.javaee.useful.support.validation;

import br.com.lucasromagnoli.javaee.useful.support.number.NumberSupport;
import br.com.lucasromagnoli.javaee.useful.support.string.StringSupport;

import java.math.BigDecimal;

public class ValidationSupport {
    private ValidationSupport() {};
    
    public static void stringLengthBetween(int min, int max, String target) {
        if (!StringSupport.lengthBetween(min, max, target)) {
            throw new StringValidationException();
        }
    }
    
    public static void numberIsPositive(BigDecimal target) {
        if (!NumberSupport.isPositive(target)) {
            throw new NumberValidationException();
        }
    }

    public static void numberIsPositive(int id) {
        if (!NumberSupport.isPositive(id)) {
            throw new NumberValidationException();
        }
    }
}
