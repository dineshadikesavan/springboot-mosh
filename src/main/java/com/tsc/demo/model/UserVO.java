package com.tsc.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIgnoreProperties("field1")
@JsonFilter("UserFilter1")
public class UserVO {

    private Long userId;

    @JsonProperty("user_name")
    private String name;

    private String email;

    private String phoneNumber;

    //@JsonIgnore
    private String password;

}
