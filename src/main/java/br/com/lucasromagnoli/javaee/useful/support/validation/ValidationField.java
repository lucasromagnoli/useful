package br.com.lucasromagnoli.javaee.useful.support.validation;

public interface ValidationField<T> {
    public default String getMessage() {
        return "This field has not passed on validation";
    }

    public boolean validate(T target);
}
