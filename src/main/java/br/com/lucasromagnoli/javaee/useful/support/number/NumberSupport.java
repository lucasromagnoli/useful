package br.com.lucasromagnoli.javaee.useful.support.number;

import java.math.BigDecimal;

public class NumberSupport {
    private NumberSupport() {}
    
    public static boolean isPositive(BigDecimal target) {
        return target.compareTo(BigDecimal.ZERO) >= 0;
    }
    
    public static boolean isPositive(int target) {
        return target >= 0;
    }
}
