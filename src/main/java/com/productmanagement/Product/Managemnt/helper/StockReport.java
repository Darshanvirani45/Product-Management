package com.productmanagement.Product.Managemnt.helper;

public class StockReport {

    private int pId;
    private String name;
    private int inventoryCount;

    public StockReport() {
    }

    public StockReport(int inventoryCount, String name, int pId) {
        this.inventoryCount = inventoryCount;
        this.name = name;
        this.pId = pId;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return pId+"\t"+name+"\t"+inventoryCount;
    }
}
