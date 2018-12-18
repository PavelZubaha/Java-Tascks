package com.beer.entity;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class BoxPack {
    private int sumX2;
    private final int capacityX2;
    /**
     * Type of beer with amount of it.
     */
    private Map<String, Integer> content = new TreeMap<>(Comparator.naturalOrder());

    public BoxPack(int cellCapacity) {
        this.capacityX2 = cellCapacity * 2;
    }

    public boolean add(SKU sku) {
        if (capacityX2 - sumX2 < sku.getCellX2() || sku.getSumX2() == 0) {
            return false;
        }
        int addQuantity;
        if (capacityX2 - sumX2 > sku.getSumX2()) {
            addQuantity = sku.getSumX2() / sku.getCellX2();
        } else {
            addQuantity = (capacityX2 - sumX2) / sku.getSumX2();
        }
        if (content.containsKey(sku.getName())) {
            content.replace(sku.getName(), addQuantity + content.get(sku.getName()));
        } else {
            content.put(sku.getName(), addQuantity);
        }
        sku.setQuantity(sku.getQuantity() - addQuantity);
        sumX2 += addQuantity * sku.getCellX2();
        return true;
    }

    @Override
    public String toString() {
       return String.format("%nboxPack: %d%n    content: [%s]", (capacityX2 / 2), getContentString());
    }

    private String getContentString() {
        StringBuilder sb = new StringBuilder();
        content.forEach((s, i) -> sb.append(String.format("[name: '%s', quantity: %d], ", s, i)));
        sb.delete(sb.lastIndexOf(",") - 1, sb.length());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxPack boxPack = (BoxPack) o;
        return sumX2 == boxPack.sumX2 &&
                capacityX2 == boxPack.capacityX2 &&
                Objects.equals(content, boxPack.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sumX2, capacityX2, content);
    }
}
