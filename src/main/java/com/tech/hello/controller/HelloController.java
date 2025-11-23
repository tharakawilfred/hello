package com.tech.hello.controller;

import com.tech.hello.exception.HelloException;
import com.tech.hello.model.Hello;
import com.tech.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
@Slf4j
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping(value = "/hello-world")
    public Hello hello(@RequestParam String name) {
        log.info("Request Name: {}", name);
        return service.getMessage(name);
    }

    @ExceptionHandler(HelloException.class)
    public ResponseEntity<String> handleException(final HelloException e) {
        return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
    }
}
