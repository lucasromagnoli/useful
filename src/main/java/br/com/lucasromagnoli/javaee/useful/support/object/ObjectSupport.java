package br.com.lucasromagnoli.javaee.useful.support.object;

public class ObjectSupport {
    private ObjectSupport() {};

    public static boolean isNull(Object target) {
        return target == null;
    }
    
    public static <T> T Nvl (T firstTarget, T secondTarget) {
        return firstTarget != null ? firstTarget : secondTarget;
    }
}
