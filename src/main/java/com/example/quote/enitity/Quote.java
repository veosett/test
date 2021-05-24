package com.example.quote.enitity;

import com.example.quote.validator.QuoteConstraint;

import javax.persistence.*;

/**
 TODO add java docs
 */
@Entity
@QuoteConstraint
public class Quote {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String isin;
    private Double bid;
    private Double ask;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", isin='" + isin + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
