package com.techelevator.model;

public class InsulinType {

    private int insulinTypeId;
    private String insulinTypeName;
    private String brandName;
    private int insulinStrength;


    public int getInsulinTypeId() {
        return insulinTypeId;
    }

    public void setInsulinTypeId(int insulinTypeId) {
        this.insulinTypeId = insulinTypeId;
    }

    public String getInsulinTypeName() {
        return insulinTypeName;
    }

    public void setInsulinTypeName(String insulinTypeName) {
        this.insulinTypeName = insulinTypeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getInsulinStrength() {
        return insulinStrength;
    }

    public void setInsulinStrength(int insulinStrength) {
        this.insulinStrength = insulinStrength;
    }
}
