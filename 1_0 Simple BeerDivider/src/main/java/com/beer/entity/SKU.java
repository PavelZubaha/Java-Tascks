package com.beer.entity;

/**
 * Class SKU represents Simple Key Unit.
 */
public class SKU implements Comparable<SKU> {
    private String name;
    private double cell;
    private int quantity;

    public SKU(String name, double cell, int quantity) {
        this.name = name;
        this.cell = cell;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getCell() {
        return cell;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getSum() {
        return quantity * cell;
    }

    @Override
    public String toString() {
        return String.format("sku[name=\'%s\', cell=%.1f, quantity=%d]", name, cell, quantity);

    }

    @Override
    public int compareTo(SKU o) {
        return Double.compare(o.getCell(), cell);
    }
}
