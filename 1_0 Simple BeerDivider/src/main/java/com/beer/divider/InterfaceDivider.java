package com.beer.divider;

import com.beer.entity.BoxPack;
import com.beer.entity.SKU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface InterfaceDivider {
    /**
     * Standard sizes of boxes.
     */
    List<Integer> STANDARD_SIZES = new ArrayList<>(Arrays.asList(6, 8, 10, 12, 16, 25));

    /**
     * Method for dividing order to the boxes, with optimal value.
     * @param beer list of Simple Keeping Unit.
     * @return List of BoxPacks.
     */
    List<BoxPack> divideOrder(List<SKU> beer);
}
