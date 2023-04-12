package com.techelevator.model;

public class UserInput {


    private int inputId;
    private int userId;
    private int weight;
    private double baseLevel;
    private int insulinTypeId;
    private double targetRangeMin;
    private double targetRangeMax;
    private double criticalLow;
    private double criticalHigh;


    public double getTargetRangeMin() {
        return targetRangeMin;
    }

    public void setTargetRangeMin(double targetRangeMin) {
        this.targetRangeMin = targetRangeMin;
    }

    public double getTargetRangeMax() {
        return targetRangeMax;
    }

    public void setTargetRangeMax(double targetRangeMax) {
        this.targetRangeMax = targetRangeMax;
    }

    public double getCriticalLow() {
        return criticalLow;
    }

    public void setCriticalLow(double criticalLow) {
        this.criticalLow = criticalLow;
    }

    public double getCriticalHigh() {
        return criticalHigh;
    }

    public void setCriticalHigh(double criticalHigh) {
        this.criticalHigh = criticalHigh;
    }

    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBaseLevel() {
        return baseLevel;
    }

    public void setBaseLevel(double baseLevel) {
        this.baseLevel = baseLevel;
    }

    public int getInsulinTypeId() {
        return insulinTypeId;
    }

    public void setInsulinTypeId(int insulinTypeId) {
        this.insulinTypeId = insulinTypeId;
    }

}
