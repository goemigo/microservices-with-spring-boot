package com.emi.microservices.currencyconversionservice;

import java.math.BigDecimal;

// import jakarta.persistence.Entity;

// @Entity
public class CurrencyConversion {
    // @Id
    private Long id;

    // @Column(name="currency_from") //to avoid syntax error becasue "from" is a keyword in SQL
    private String from;

    // @Column(name="currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversion() {
    }

    
    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = this.quantity.multiply(this.conversionMultiple);
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }
    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }
    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    
}
