package com.beer.divider;

import com.beer.entity.BoxPack;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class represents simple solution on Beer Divide Task.
 */
public class Divider implements InterfaceDivider {
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

    public Divider() {
        this(InterfaceDivider.STANDARD_SIZES);
    }

    public List<BoxPack> divideOrder(List<SKU> beer) {
        //sorts sku's from max to min value (see SKU.compareTo(SKU)).
        beer.sort(SKU::compareTo);
        //get sum of List of SKUs
        double sum = beer.stream().mapToDouble(SKU::getSum).sum();
        //creat result List
        List<BoxPack> boxes = new ArrayList<>();
        //fill result list with BoxPack
        //for each from returned by getSizesList creating new BoxPack.
        getSizesList(sum, getMinCellFromOrder(beer)).forEach((i) -> boxes.add(new BoxPack(i)));
        //Transfer from each SKU from bear list to result list of boxes.
        boxes.forEach(boxPack -> beer.forEach(boxPack::add));
        return boxes;
    }

    /**
     * Get minimum cell value from order list.
     * @param beer order(list of sku's)
     * @return min cell.
     */
    private double getMinCellFromOrder(List<SKU> beer) {
        double minCell = 1;
        for(SKU s : beer) {
            if (s.getCell() == 0.5D) {
                minCell = 0.5D;
                break;
            }
        }
        return minCell;
    }

    /**
     * Method generate list of needed sizes.
     * @param requiredSpace you need specify needed space;
     * @param minCell - min cell value of order.
     * @return list of sizes.
     */
    private List<Integer> getSizesList(double requiredSpace, double minCell) {
//      System.out.println("VOLUME NEED: " + ((float) t) / 2);
        List<Integer> result = new ArrayList<>();
        //As boxSizes has sorted, we have min size - last element of list.
        int MIN_SIZE = boxSizes.get(boxSizes.size() - 1);
        // check if the box is suitable in cycle.
        // for different(0, 1...) sizes of empty space.
        for (double emptySpace = 0; requiredSpace > 0; emptySpace+=minCell) {
            //check in cycle each size of box.
            for (int i = 0, size; i < boxSizes.size(); i++) {
                size = boxSizes.get(i);
                //check condition as trigger.
                if (condition(requiredSpace, MIN_SIZE, emptySpace, size)) {
                    //when condition true add current checking size to result list
                    result.add(size);
                    requiredSpace -= size;
                    //if size is suitable check this size one more time
                    i = i - 1;
                    //after adding before checking should reset emptySpace
                    emptySpace = 0;
                }
            }
        }
        return result;
    }

    private boolean condition(double requiredSpace, int MIN_SIZE, double emptySpace, int size) {
        return requiredSpace + emptySpace - size >= MIN_SIZE
                || size - emptySpace - requiredSpace <= 1.5
                && size - requiredSpace >= 0;
    }
    /**
     * Method show in console example of getListSizeWorks with different required space.
     */
    public static void showGetListSizeWork() {
        InterfaceDivider divider = new Divider();
        for (double i = 0; i < 76; i+=0.5) {
            //we specify different required space(total order volume)
            System.out.println(i + " - " + ((Divider) divider).getSizesList(i, 0.5));
        }
    }
}
