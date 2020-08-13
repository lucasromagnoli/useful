package br.com.lucasromagnoli.javaee.useful.support.validation;

import br.com.lucasromagnoli.javaee.useful.support.object.ObjectSupport;
import br.com.lucasromagnoli.javaee.useful.support.string.StringSupport;

import java.util.HashMap;
import java.util.Map;

public class ValidationSupport {
    private final Object target;
    private final Map<String, ValidationField> validations;

    private ValidationSupport(Object target) {
        this.target = target;
        this.validations = new HashMap<>();
    };

    public ValidationSupport field(String field, ValidationField validationField) {
        if (StringSupport.isEmpty(field) || ObjectSupport.isNull(validationField)) {
            throw new NullPointerException("The field needs a name and its validation rule");
        }

        validations.put(field, validationField);
        return this;
    }

    public static ValidationSupport target(Object target) {
        if (target == null) {
            throw new NullPointerException("The target cannot be null");
        }
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

        return new Validation(validationDetails, validationDetails.size() > 0
                ? ValidationType.UNSUCCESSFUL
                : ValidationType.SUCCESS);
    }

    private enum Category {
        STOP_ON_FIRST,
        VALIDATE_ALL
    }
}
