package com.example.eigerxassignment.RecursiveDigitSummer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IntSummerTest {
    private final IntSummer intSummer = new IntSummer();

    @Test
    public void testSummer1(){
        assertEquals(27, intSummer.sumDigits(2347623));
    }

    @Test
    public void testSummer2(){
        assertEquals(0, intSummer.sumDigits(0));
    }

    @Test
    public void testSummer3(){
        assertEquals(1, intSummer.sumDigits(100));
    }

    @Test
    public void testSummer4(){
        assertEquals(20, intSummer.sumDigits(9911));
    }

    @Test
    public void testSummer5(){
        assertThrows(IllegalArgumentException.class, () -> intSummer.sumDigits(-4));
    }
}