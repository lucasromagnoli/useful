package br.com.lucasromagnoli.javaee.useful.support.validation;

import br.com.lucasromagnoli.javaee.useful.support.reflection.ReflectionSupport;
import org.junit.Before;
import org.junit.Test;

public class ReflectionSupportTest {
    private Target target = new Target();

    @Before
    public void setUp() throws Exception {
        target.setAge(30);
        target.setName("Lucas Ramos Romagnoli");
    }

    @Test
    public void testGetNameReflection() {
        assert(ReflectionSupport.getMethod("name", target).equals(target.getName()));
    }
}
