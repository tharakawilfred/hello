package com.tech.hello.validator;

import com.tech.hello.exception.HelloException;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloValidator {

    // Check if the name is null or empty, if so throw exception
    public void validate(String name) {
        if(StringUtils.isBlank(name)) {
            log.error("Name parameter is missing or empty");
            throw new HelloException("Invalid Request");
        }
    }
}