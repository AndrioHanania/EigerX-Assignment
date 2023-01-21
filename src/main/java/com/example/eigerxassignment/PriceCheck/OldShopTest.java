package com.example.eigerxassignment.PriceCheck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class OldShopTest {
    private final OldShop oldShop = new OldShop();

    @Test
    public void priceCheckTester1(){
        int result = oldShop.priceCheck(
                Arrays.asList("rice", "sugar", "wheat", "cheese"),
                Arrays.asList(16.89F, 56.92F, 20.89F, 345.99F),
                Arrays.asList("rice", "cheese"),
                Arrays.asList(18.99F, 400.89F)
        );
        assertEquals(2, result);
    }

    @Test
    public void priceCheckTester2(){
        int result = oldShop.priceCheck(
                Arrays.asList("eggs", "milk",  "cheese"),
                Arrays.asList(2.89F, 3.29F, 5.79F),
                Arrays.asList("eggs", "eggs", "cheese", "milk"),
                Arrays.asList(2.89F, 2.99F, 5.97F, 3.29F)
        );
        assertEquals(2, result);
    }

    @Test
    public void priceCheckTester3(){
        assertThrows(IllegalArgumentException.class,
                () -> oldShop.priceCheck(
                        Arrays.asList("eggs", "cheese"),
                        Arrays.asList(2.89F, 3.29F, 5.79F),
                        Arrays.asList("eggs", "eggs", "cheese", "milk"),
                        Arrays.asList(2.89F, 2.99F, 5.97F, 3.29F)
                ));
    }

    @Test
    public void priceCheckTester4(){
        assertThrows(IllegalArgumentException.class,
                () -> oldShop.priceCheck(
                        Arrays.asList("eggs", "milk",  "cheese"),
                        Arrays.asList(2.89F, 3.29F, 5.79F),
                        Arrays.asList("eggs", "cheese", "milk"),
                        Arrays.asList(2.89F, 2.99F, 5.97F, 3.29F)
                ));
    }

    @Test
    public void priceCheckTester5(){
        assertThrows(IllegalArgumentException.class,
                () -> oldShop.priceCheck(
                        Arrays.asList("eggs", "milk",  "cheese"),
                        Arrays.asList(2.89F, 3.29F, 5.79F),
                        Arrays.asList("computer", "eggs", "cheese", "milk"),
                        Arrays.asList(2.89F, 2.99F, 5.97F, 3.29F)
                ));
    }
}
