package com.tsc.demo.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonV2 {

    private FullName name;
    
}
