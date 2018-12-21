package com.beer.divider;

import com.beer.entity.BoxPack;
import com.beer.entity.SKU;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test class for Divider.
 */
public class DividerTest {

    private InterfaceDivider testedInstance;
    private List<SKU> testedBeerOrder;
    private List<BoxPack> expectedList;

    /**
     * Before testing get tested instances.
     */
    @org.junit.Before
    public void setUp() {
        testedInstance = new Divider(InterfaceDivider.STANDARD_SIZES);
        testedBeerOrder = Collections.singletonList(new SKU("beer1", 0.5, 1));
        expectedList = Collections.singletonList(new BoxPack(6));
        expectedList.get(0).add(new SKU("beer1", 0.5, 1));
    }

    /**
     * Simple test for divider.divideOrder().
     * Test checks that exacted array of BeerBoxes, created manually,
     * is equals of returned by Divider one.
     */
    @org.junit.Test
    public void divideOrder() {
        assertArrayEquals(expectedList.toArray(),
                testedInstance.divideOrder(testedBeerOrder).toArray());
    }
}