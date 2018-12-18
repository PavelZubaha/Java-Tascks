package com.beer.entity;

import java.util.Comparator;
import java.util.Map;
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
        if (capacityX2 - sumX2 < sku.getCellX2()) {
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
       return String.format("boxPack: %d%n    content: [%s]%n", (capacityX2 / 2), getContentString());
    }

    private String getContentString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : content.entrySet()) {
            sb.append(String.format("name = '%s', value = %d, ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
