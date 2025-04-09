package com.railway.paymentgatewayservice.model;

public class Payment {
    private String pnr;
    private String paymentMethod; // e.g., Credit Card, Debit Card

    // Getters and Setters
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
