package com.tsc.demo.controller;

import com.tsc.demo.model.FullName;
import com.tsc.demo.model.Person;
import com.tsc.demo.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(path = "/person", params = "version=1")
    public Person personParamVersion() {
        return new Person("Dinesh");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 personParamVersion2() {
        return new PersonV2(new FullName("Dinesh", "Adikesavan"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Person personHeaderVersion() {
        return new Person("Dinesh");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personHeaderVersion2() {
        return new PersonV2(new FullName("Dinesh", "Adikesavan"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Person personMediatypeVersion() {
        return new Person("Dinesh");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personMediatypeVersion2() {
        return new PersonV2(new FullName("Dinesh", "Adikesavan"));
    }

}
