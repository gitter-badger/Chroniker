package com.chroniker.client.utils;

import java.util.concurrent.ThreadLocalRandom;

/** Contains all math-related functions elusive to Chroniker */
public class ChronikerMath {

    /**
     * Method to decide whether a given value is a multiple by another given value.
     * @param num Value to be tested.
     * @param multiplier Value for the first value to be tested against.
     * @return Whether or not the first given value is a multiple of the second given value.
     */
    public static boolean isMultiple(int num, int multiplier) {
        return (num % multiplier) == 0;
    }

}
