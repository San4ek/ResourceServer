package com.example.demoapi.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Validated
@RestController
@RequestMapping(produces="application/json")
public @interface Rest {
    @AliasFor(annotation = RequestMapping.class)
    String[] path() default {};
}
