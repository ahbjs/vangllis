package com.bcal.www.vangills.insert;


public class InsertItem {

    private String productName;
    private double price;
    private int availableUnits;
    private String unitType;

    public InsertItem() {
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
