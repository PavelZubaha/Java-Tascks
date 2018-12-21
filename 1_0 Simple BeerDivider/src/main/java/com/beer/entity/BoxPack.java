package com.beer.entity;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class BoxPack {
    /**
     * Total volume(space, size) added to this BoxPack.
     */
    private int sum = 0;
    /**
     * Capacity of this BoxPack.
     */
    private final int capacity;
    /**
     * Type of beer with amount of it.
     */
    private final Map<String, Long> content = new TreeMap<>(Comparator.naturalOrder());

    public BoxPack(int cellCapacity) {
        this.capacity = cellCapacity;
    }

    /**
     * Method for adding into box SKU.
     * Method try to take some quantity from specified SKU and put it into this box.
     * @param sku sku for adding.
     */
    public void add(SKU sku) {
        //reject case
        if (capacity - sum < sku.getCell() || sku.getSum() == 0) {
            return;
        }
        long addQuantity;
        if (capacity - sum > sku.getSum()) {
            addQuantity = Math.round(sku.getSum() / sku.getCell());
        } else {
            addQuantity = Math.round((capacity - sum) / sku.getSum());
        }
        if (content.containsKey(sku.getName())) {
            content.replace(sku.getName(), addQuantity + content.get(sku.getName()));
        } else {
            content.put(sku.getName(), addQuantity);
        }
        sku.setQuantity((int)(sku.getQuantity() - addQuantity));
        sum += addQuantity * sku.getCell();
    }

    @Override
    public String toString() {
       return String.format("%nboxPack: %d%n    content: [%s]", capacity, getContentString());
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
        return sum == boxPack.sum &&
                capacity == boxPack.capacity &&
                Objects.equals(content, boxPack.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, capacity, content);
    }
}
