package com.emi.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name="currency-exchange",url="localhost:8000") //this name must be the application name of for the service we want to call
/*the above is hardcoding the service instance we want to call in this service
instead we can use feign to talk to eureka and auto load balance among the instances that can be used
*/
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
        @PathVariable String from,
        @PathVariable String to
        );
}
