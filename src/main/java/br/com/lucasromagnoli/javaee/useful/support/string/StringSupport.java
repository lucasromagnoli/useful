package br.com.lucasromagnoli.javaee.useful.support.string;

public class StringSupport {
    private StringSupport(){};

    public static String firstLetterToUpperCase(String target) {
        return new StringBuilder(target)
                .replace(0,1, String.valueOf(target.charAt(0)).toUpperCase())
                .toString();
    }

    public static boolean isEmpty(String target) {
        return target == null || target.trim().length() == 0;
    }
}
