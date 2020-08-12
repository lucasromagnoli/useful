package br.com.lucasromagnoli.javaee.useful.support.validation;

import java.util.HashMap;
import java.util.Map;

public class ValidationSupport {
    private Object target;
    private Map<String, ValidationField> validations;

    private ValidationSupport(Object target) {
        this.target = target;
        this.validations = new HashMap<>();
    };

    public ValidationSupport field(String field, ValidationField validationField) {
        validations.put(field, validationField);

        return this;
    }

    public static ValidationSupport target(Object target) {
        return new ValidationSupport(target);
    }

    public Validation validate() {
        return validate(Category.STOP_ON_FIRST);
    }

    public Validation validateAll() {
        return validate(Category.VALIDATE_ALL);
    }

    private Validation validate(Category stopOnFirst) {
        Map<String, String> validationDetails = new HashMap<>();

        for (Map.Entry<String, ValidationField> validation : validations.entrySet()) {
            ValidationField validationField = validation.getValue();
            if (!validationField.validate(target)) {
                validationDetails.put(validation.getKey(), validationField.getMessage());
                if (stopOnFirst.equals(Category.STOP_ON_FIRST)) {
                    break;
                }
            }
        }

        return new Validation(validationDetails,
                validationDetails.size() > 0 ? ValidationType.UNSUCCESSFUL : ValidationType.SUCCESS);
    }

    private enum Category {
        STOP_ON_FIRST,
        VALIDATE_ALL
    }
}
