package com.beer.entity;

public class SKU implements Comparable<SKU> {
    private String name;
    private int cellX2;
    private int quantity;

    public SKU(String name, float cell, int quantity) {
        this.name = name;
        this.cellX2 = Math.round(cell * 2);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getCellX2() {
        return cellX2;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getSumX2() {
        return quantity * cellX2;
    }

    @Override
    public String toString() {
        return "SKU[" +
                "name='" + name + '\'' +
                ", cell=" + ((float) cellX2) / 2 +
                ", quantity=" + quantity +
                ']';
    }

    @Override
    public int compareTo(SKU o) {
        return Integer.compare(o.getCellX2(), cellX2);
    }
}
