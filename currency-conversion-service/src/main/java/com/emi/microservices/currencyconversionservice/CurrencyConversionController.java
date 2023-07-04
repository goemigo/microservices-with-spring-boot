package com.emi.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateConversion(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity
    ) {
        CurrencyConversion currencyConversion = new CurrencyConversion(1001L,"USD","INR",BigDecimal.valueOf(65),BigDecimal.valueOf(10));
        String port = environment.getProperty("local.server.port");
        currencyConversion.setEnvironment(port);
        return currencyConversion;

    }
}
