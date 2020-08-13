package br.com.lucasromagnoli.javaee.useful.support.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationSupportTest {
    private Target target = new Target();

    @Before
    public void setUp() throws Exception {
        target.setAge(30);
        target.setName("Lucas Ramos Romagnoli");
    }

    @Test
    public void testValidationTypeSuccessCase() {
        Validation validation = ValidationSupport.target(target)
                .field("age", (obj) -> ((Target)obj).getAge().equals(30) )
                .field("name", (obj) -> ((Target)obj).getName().equalsIgnoreCase("lucas Ramos RomAGnOli") )
                .validate();

        assertEquals(validation.getValidationType(), ValidationType.SUCCESS);
    }

    @Test
    public void testValidationTypeUnsuccessCase() {
        Validation validation = ValidationSupport.target(target)
                .field("age", (ValidationField<Target>) target -> target.getAge().equals(20))
                .field("name", new ValidationField<Target>() {
                    @Override
                    public String getMessage() {
                        return "The name needs to be: Lucas R. Romagnoli.";
                    }

                    @Override
                    public boolean validate(Target target) {
                        return target.getName().equals("Lucas R. Romagnoli");
                    }
                })
                .validateAll();

        System.out.println(validation.getDetails());
        assertEquals(validation.getValidationType(), ValidationType.UNSUCCESSFUL);
    }

    @Test(expected = NullPointerException.class)
    public void testValidationTargetNull() {
        Validation validation = ValidationSupport.target(null)
                .field("age", (obj) -> ((Target)obj).getAge().equals(30) )
                .validate();
    }

    @Test(expected = NullPointerException.class)
    public void testValidationFieldOrLogicNull() {
        Validation validation = ValidationSupport.target(target)
                .field("", null)
                .validate();
    }

}