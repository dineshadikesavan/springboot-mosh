package com.tsc.demo.controller;

import com.tsc.demo.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {

    private final MessageSource messageSource;

    public HomeController(MessageSource messageSource, UserService userService) {
        this.messageSource = messageSource;
    }

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World!!";
    }

    @GetMapping(path = "good-morning-internationalized")
    public String goodMorningByLanguage() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }


}
