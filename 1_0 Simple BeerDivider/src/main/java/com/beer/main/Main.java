package com.beer.main;

import com.beer.divider.Divider;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.List;

/**
 * Class demonstrates how to use divider work
 */
public class Main {
    public static void main(String[] args) {
        Divider analyzer = new Divider(Divider.getStandartSizesList());
        exampleOfDividerWork(analyzer);
    }

    /**
     * Method shows example how it solution can work.
     * @param a Divider for working.
     */
    private static void exampleOfDividerWork(Divider a) {
        SKU sku;
        List<SKU> beer;
        int i;
        //generate lists of beer. And fill it in internal cycle by generated SKU's.
        for (int j = 1; j <= 5; j++) {
            beer = new ArrayList<>();
            for (i = 1; i <= j; i++) {
                sku = new SKU("beer" + i % 3, i % 2 + 0.5F, i % 4);
                beer.add(sku);
            }
            System.out.printf("input:%n%s%n", beer);
            System.out.printf("result:%n%s%n%n", a.divideOrder(beer));
        }
    }
}
