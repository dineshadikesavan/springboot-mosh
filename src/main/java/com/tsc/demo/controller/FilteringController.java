package com.tsc.demo.controller;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tsc.demo.model.UserVO;
import com.tsc.demo.service.UserService;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    private final UserService userService;

    public FilteringController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/filtering")
    public MappingJacksonValue filtering() {
        UserVO userVO = this.userService.getUser(1L);
        MappingJacksonValue mjv = new MappingJacksonValue(userVO);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("user_name", "email");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter1", filter);
        mjv.setFilters(filters);
        return mjv;
    }

    @GetMapping(path = "/users/filtering-list")
    public MappingJacksonValue filteringList() {
        List<UserVO> users = this.userService.findAllUsers();
        MappingJacksonValue mjv = new MappingJacksonValue(users);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("user_name", "email", "phoneNumber");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter1", filter);
        mjv.setFilters(filters);
        return mjv;
    }

}
