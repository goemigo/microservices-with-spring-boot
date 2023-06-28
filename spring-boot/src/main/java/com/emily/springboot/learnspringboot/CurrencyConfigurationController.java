package com.emily.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
    @Autowired
    private CurrencyServiceConfiguration configuration; //too get an instance from CurrencyServiceConfiguration by @Component

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveCurrency(){
        return configuration;
    }
    
}
