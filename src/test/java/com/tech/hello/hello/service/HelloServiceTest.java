package com.tech.hello.hello.service;

import com.tech.hello.hello.exception.HelloException;
import com.tech.hello.hello.model.Hello;
import com.tech.hello.hello.validator.HelloValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class HelloServiceTest {

    @MockitoBean
    private HelloValidator validator;

    @Autowired
    private HelloService helloService;

    @Test
    void testFirstHalfAlphabet() {
        String name = "Amal";

        doNothing().when(validator).validate(name);
        Hello hello = helloService.getMessage(name);
        verify(validator).validate(name);
        assertNotNull(hello);
        assertEquals("Hello Amal", hello.getMessage());
    }

    @Test
    void testSecondHalfAlphabet() {
        String name = "Namal";
        doNothing().when(validator).validate(name);
        HelloException exception = assertThrows(HelloException.class, () -> helloService.getMessage(name));

        verify(validator).validate(name);
        assertEquals("Invalid Request", exception.getError());
    }

    @Test
    void testNullName() {
        String name = null;
        doThrow(new HelloException("Invalid Request"))
                .when(validator).validate(name);

        HelloException exception = assertThrows( HelloException.class, () -> helloService.getMessage(name));

        verify(validator).validate(null);
        assertEquals("Invalid Request", exception.getError());
    }

    @Test
    void testLowercase() {
        String name = "binura";

        doNothing().when(validator).validate(name);
        Hello hello = helloService.getMessage(name);

        verify(validator).validate(name);
        assertEquals("Hello binura", hello.getMessage());
    }
}