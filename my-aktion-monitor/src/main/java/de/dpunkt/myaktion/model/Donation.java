package de.dpunkt.myaktion.model;

import java.io.Serializable;

public class Donation implements Serializable {
    private static final long serialVersionUID = -1392398877357073405L;

    public Donation() {
    }

    private Double amount;
    private String donorName;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }
}
