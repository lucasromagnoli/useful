package br.com.lucasromagnoli.javaee.useful.support.string;

public class StringSupport {
    private StringSupport() {};

    public static String firstLetterToUpperCase(String target) {
        return new StringBuilder(target)
                .replace(0, 1, String.valueOf(target.charAt(0)).toUpperCase())
                .toString();
    }

    public static boolean lengthBetween(int min, int max, String target) {
        return target.length() >= min && target.length() <= max;
    }

    public static boolean isEmpty(String target) {
        return target == null || target.trim().length() == 0;
    }

    public static String camelToSnake(String target) {
        return target
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}
