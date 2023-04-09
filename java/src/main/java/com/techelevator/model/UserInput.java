package com.techelevator.model;

public class UserInput {


    private int inputId;
    private int userId;
    private int weight;
    private double baseLevel;
    private int insulinTypeId;
    private double insulinStrength;

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

    public double getInsulinStrength() {
        return insulinStrength;
    }

    public void setInsulinStrength(double insulinStrength) {
        this.insulinStrength = insulinStrength;
    }
}
