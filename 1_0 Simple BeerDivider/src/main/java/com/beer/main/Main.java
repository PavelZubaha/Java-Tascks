package com.beer.main;

import com.beer.divider.Divider;
import com.beer.divider.InterfaceDivider;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.List;

/**
 * Class demonstrates how to use divider work
 */
public class Main {
    public static void main(String[] args) {
//        exampleOfDividerWork(divider);
        Divider.showGetListSizeWork();
    }

    /**
     * Method shows example how it solution can work.
     */
    private static void exampleOfDividerWork() {
        InterfaceDivider d = new Divider();
        SKU sku;
        List<SKU> beer;
        int i;
        //generate lists of beer, fill it in cycle by generated SKU's.
        for (int j = 1; j <= 5; j++) {
            beer = new ArrayList<>();
            for (i = 1; i <= j; i++) {
                sku = new SKU("beer" + i % 3, i % 2 + 0.5F, i % 4);
                beer.add(sku);
            }
            System.out.printf("input:%n%s%n", beer);
            System.out.printf("result:%n%s%n%n", d.divideOrder(beer));
        }
    }

}
