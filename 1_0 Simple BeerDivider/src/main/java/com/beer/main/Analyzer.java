package com.beer.main;

import com.beer.entity.BoxPack;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Analyzer {
    private static List<Integer> boxSizes = new ArrayList<>();

    public static void main(String[] args) {
        boxSizes.addAll(Arrays.asList(6, 8, 10, 12, 16, 25));
        Collections.reverse(boxSizes);
        SKU sku;
        List<SKU> beer;
        int i;
        for (int j = 1; j <= 10; j++) {
            beer = new ArrayList<>();
            for (i = 1; i <= j; i++) {
                sku = new SKU("beer" + i % 3, i % 5 + 0.5F, i % 4);
                beer.add(sku);
                System.out.println(sku);
            }
            System.out.println(divideOrder(beer));
        }
    }


    public static List<BoxPack> divideOrder(List<SKU> beer) {
        beer.sort(SKU::compareTo);
        int[] totalCelsX2 = {0};
        beer.forEach((sku) -> totalCelsX2[0] += sku.getSumX2());
        List<BoxPack> boxes = new ArrayList<>();
        getSizesList(totalCelsX2[0]).forEach((i) -> boxes.add(new BoxPack(i)));
        boxes.forEach(boxPack -> beer.forEach(boxPack::add));
        return boxes;
    }

    private static List<Integer> getSizesList(int needsX2) {
        System.out.println("VOLUME NEED: " + ((float) needsX2) / 2);
        boolean flag = false;
        List<Integer> result = new ArrayList<>();
        int emptyPlaysX2 = 0;
        while (needsX2 > 0) {
            for (int i = 0, sizeX2; i < boxSizes.size() && needsX2 > 0; i++) {
                sizeX2 = boxSizes.get(i) * 2;
                while (true) {
                    if (needsX2 + emptyPlaysX2 - sizeX2 >= 12) {
                        flag = true;
                    } else if (sizeX2 - emptyPlaysX2 - needsX2 <= 3 &&
                    sizeX2 - needsX2 - emptyPlaysX2  >= 0
                    ) {
                        flag = true;
                    }
                    if (flag) {
                        System.out.printf("   size: %d, left: %.1f%n", Math.round(sizeX2 / 2), ((float) needsX2) / 2);
                        result.add(Math.round(sizeX2 / 2));
                        needsX2 -= (sizeX2);
                        emptyPlaysX2 = 0;
                        i = -1;
                        flag = false;
                        break;
                    } else {
                        break;
                    }
                }
            }
            emptyPlaysX2 += 1;
        }
        return result;
    }
}
