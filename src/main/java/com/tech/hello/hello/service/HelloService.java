package com.tech.hello.hello.service;

import com.tech.hello.hello.exception.HelloException;
import com.tech.hello.hello.model.Hello;
import com.tech.hello.hello.validator.HelloValidator;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    @Autowired
    private HelloValidator validator;

    /*
        Validate the name. Read the first letter of the name and check where it belongs.
     */
    public Hello getMessage(String name) {

        validator.validate(name);

        char firstChar = Character.toLowerCase(name.charAt(0));
        Hello hello;

        if (firstChar >= 'a' && firstChar <= 'm'){
            hello = new Hello();
            hello.setMessage("Hello " + name);
            log.info("The first letter of the name parameter is in the first half of the English alphabet (A–M or a–m)");
        } else {
            log.error("The first letter is in the second half (N–Z or n–z):");
            throw new HelloException("Invalid Request");
        }
        return hello;
    }
}