package com.tsc.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("lazyService")
@Lazy
public class LazyService {

    public LazyService() {
        System.out.println("Lazy service created");
    }
}
