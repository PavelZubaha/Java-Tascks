package com.beer.divider;

import com.beer.entity.BoxPack;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class represents simple solution on Beer Divide Task.
 */
public class Divider {

    private List<Integer> boxSizes;

    /**
     * Constructor.
     * @param boxSizes list of sizes.
     */
    public Divider(List<Integer> boxSizes) {
        this.boxSizes = boxSizes;
        boxSizes.sort(Integer::compareTo);
        Collections.reverse(boxSizes);
    }

    public static List<Integer> getStandartSizesList() {
        List<Integer> sizes = new ArrayList<>(Arrays.asList(6, 8, 10, 12, 16, 25));
        return sizes;
    }

    /**
     * Method for dividing order to the boxes, with optimal value.
     * @param beer list of Simple Keeping Unit.
     * @return List of BoxPacks.
     */
    public List<BoxPack> divideOrder(List<SKU> beer) {
        beer.sort(SKU::compareTo); //sorts sku's - first will bee with max cell last with smaller.
        int[] totalCelsX2 = {0}; //for lymbda accept needs to create unmutable such as array.
        beer.forEach((sku) -> totalCelsX2[0] += sku.getSumX2()); //get sum of List of SKU, save to array[0]
        List<BoxPack> boxes = new ArrayList<>(); //creat result List
        getSizesList(totalCelsX2[0]).forEach((i) -> boxes.add(new BoxPack(i))); //fill result list with BoxPack
        boxes.forEach(boxPack -> beer.forEach(boxPack::add)); //Transfer from each SKU from bear to result list.
        return boxes;
    }

    /**
     * Method generate list of needed sizes.
     * @param needsX2 you need specify needed amount * 2;
     * @return list of sizes.
     */
    private List<Integer> getSizesList(int needsX2) {
//        System.out.println("VOLUME NEED: " + ((float) needsX2) / 2);
        List<Integer> result = new ArrayList<>();
        int MIN_SIZE = boxSizes.get(boxSizes.size() - 1);
        int emptyPlaysX2 = 0;
        while (needsX2 > 0) {
            for (int i = 0, sizeX2; i < boxSizes.size() && needsX2 > 0; i++) {
                sizeX2 = boxSizes.get(i) * 2;
                if (needsX2 + emptyPlaysX2 - sizeX2 >= MIN_SIZE * 2
                        || sizeX2 - emptyPlaysX2 - needsX2 <= 3
                        && sizeX2 - needsX2 - emptyPlaysX2 >= 0) {
//                    System.out.printf("   size: %d, left: %.1f%n", Math.round(sizeX2 / 2), ((float) needsX2) / 2);
                    result.add(Math.round(sizeX2 / 2));
                    needsX2 -= (sizeX2);
                    emptyPlaysX2 = 0;
                    i = i - 1;
                }
            }
            emptyPlaysX2 += 1;
        }
        return result;
    }
}
