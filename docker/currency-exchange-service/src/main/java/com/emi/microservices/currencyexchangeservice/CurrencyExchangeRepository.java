package com.emi.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
    //the from and to in function name are the column name in database, can be changed to like "findByFrom" or "findByFromAndId"...
    //and jpa will auto-convert it into query
    
}
