package com.tsc.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FullName {

    private String firstName;

    private String lastName;
}
