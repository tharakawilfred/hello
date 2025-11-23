package com.tech.hello.hello.validator;

import com.tech.hello.hello.exception.HelloException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloValidatorTest {

    @InjectMocks
    private HelloValidator helloValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMessage() {
        String name = "";
        HelloException exception = assertThrows(HelloException.class, () -> helloValidator.validate(name));
        assertEquals("Invalid Request", exception.getError());
    }
}