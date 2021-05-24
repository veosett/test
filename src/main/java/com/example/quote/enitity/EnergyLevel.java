package com.example.quote.enitity;

import javax.persistence.*;

/**
 TODO add java docs
 */
@Entity
public class EnergyLevel {
    @Id
    private String isin;
    private Double level;

    public String getIsin() {
        return isin;
    }

    public EnergyLevel() {
    }

    public EnergyLevel(String isin, Double level) {
        this.isin = isin;
        this.level = level;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }
}
