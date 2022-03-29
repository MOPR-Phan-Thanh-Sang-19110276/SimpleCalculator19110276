package com.android.s19110276;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator mCalculator;
    private static final double DELTA = 1E-10;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(mCalculator.add(858, 23424), 24282, DELTA);
        assertEquals(mCalculator.add(0, -21452354), -21452354, DELTA);
        assertEquals(mCalculator.add(5672343, 0), 5672343, DELTA);
        assertEquals(mCalculator.add(0, 0), 0, DELTA);
        assertEquals(mCalculator.add(-2345345, -2352344), -4697689, DELTA);
    }

    @Test
    public void sub() {
        assertEquals(mCalculator.sub(9456734, 34566), 9422168, DELTA);
        assertEquals(mCalculator.sub(0, -21452354), 21452354, DELTA);
        assertEquals(mCalculator.sub(5672343, 0), 5672343, DELTA);
        assertEquals(mCalculator.sub(0, 0), 0, DELTA);
        assertEquals(mCalculator.sub(-2345345, -2352344), 6999, DELTA);
    }

    @Test
    public void mul() {
        assertEquals(mCalculator.mul(2345, 4564), 10702580, DELTA);
        assertEquals(mCalculator.mul(458342224, 0), 0, DELTA);
        assertEquals(mCalculator.mul(0, 1232976), 0, DELTA);
        assertEquals(mCalculator.mul(0, 0), 0, DELTA);
        assertEquals(mCalculator.mul(-987, -2374), 2343138, DELTA);
    }

    @Test
    public void div() {
        assertEquals(mCalculator.div(734453, 23), 31932.739130434784, DELTA);
        assertEquals(mCalculator.div(734453, 0), Double.POSITIVE_INFINITY, DELTA);
        assertEquals(mCalculator.div(-413851104, 5634), -73456, DELTA);
        assertEquals(mCalculator.div(413851104, -5634), -73456, DELTA);
        assertEquals(mCalculator.div(-413851104, -5634), 73456, DELTA);
        assertEquals(mCalculator.div(5645, 345523), 0.016337552058763093, DELTA);
    }

    @Test
    public void exp() {
        assertEquals(mCalculator.exp(6, 2), 36, DELTA);
        assertEquals(mCalculator.exp(345, 3), 41063625, DELTA);
        assertEquals(mCalculator.exp(5484964, 0.5), 2342, DELTA);
        assertEquals(mCalculator.exp(7647, -2), 1.710085480503837E-8, DELTA);
        assertEquals(mCalculator.exp(-7647, 3), -4.47170629023E11, DELTA);
        assertEquals(mCalculator.exp(45672, 0), 1, DELTA);
        assertEquals(mCalculator.exp(0, 23), 0, DELTA);
    }

    @Test
    public void fact() {
        assertEquals(mCalculator.fact(10), 3628800, DELTA);
        assertEquals(mCalculator.fact(15.3), 2.004310016E9, DELTA);
        assertEquals(mCalculator.fact(0), 1, DELTA);
        assertEquals(mCalculator.fact(1), 1, DELTA);
        assertEquals(mCalculator.fact(12345), Double.POSITIVE_INFINITY, DELTA);
    }

    @Test
    public void loga() {
        assertEquals(mCalculator.loga(10, 100), 2, DELTA);
        assertEquals(mCalculator.loga(5678, 123), 0.55668522688349, DELTA);
        assertEquals(mCalculator.loga(0.1234, 3213), -3.859325664972, DELTA);
        assertEquals(mCalculator.loga(2345, 2345), 1, DELTA);
    }
}