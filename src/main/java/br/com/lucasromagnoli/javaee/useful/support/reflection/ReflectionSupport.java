package br.com.lucasromagnoli.javaee.useful.support.reflection;

import br.com.lucasromagnoli.javaee.useful.support.string.StringSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSupport {
    private ReflectionSupport() {};

    public static <T> Object getMethod(String field, T target) {
        String methodName = "get"+StringSupport.firstLetterToUpperCase(field);
        try {
            Method method = target.getClass().getMethod(methodName);
            return method.invoke(target);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
