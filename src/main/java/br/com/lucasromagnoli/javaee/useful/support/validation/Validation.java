package br.com.lucasromagnoli.javaee.useful.support.validation;

import java.util.Map;

public class Validation {
    private Map<String, String> details;
    private ValidationType validationType;

    public Validation(Map<String, String> details, ValidationType type) {
        this.details = details;
        this.validationType = type;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public ValidationType getValidationType() {
        return validationType;
    }
}
