package org.dng;

import java.time.LocalDate;

public class Car {
    private String gosNom;
    private int power;
    private int issueYear;
    static double taxRate = 1;

    public Car(String gosNom, int power, int issueYear) {
        this.gosNom = gosNom;
        this.power = power;
        this.issueYear = issueYear;
    }

    public String getGosNom() {
        return gosNom;
    }

    public void setGosNom(String gosNom) {
        this.gosNom = gosNom;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public static void setTaxRate(double taxRate) {
        Car.taxRate = taxRate;
    }

    public double taxSum() {
        return (power * taxRate - (issueYear - LocalDate.now().getYear()) / taxRate);
    }

    @Override
    public String toString() {
        return "for car "+getGosNom()+" with power "+getPower()+" and issueYear "+getIssueYear()+" tax = "+taxSum();
    }
}
