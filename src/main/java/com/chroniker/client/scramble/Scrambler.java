package com.chroniker.client.scramble;

import org.apache.commons.lang3.RandomUtils;

public class Scrambler {

    //Basic scramble. Nothing smart about this. Used for testing.
    public static String randomMoveScramble(int min, int max, char... elements) {

        for (char element: elements
             ) {
            System.out.println(element);
        }

        StringBuilder scramble = new StringBuilder();

        int size = RandomUtils.nextInt(min, max + 1);

        int previousMove = RandomUtils.nextInt(0, elements.length);

        for (int i = 0; i < size; i++) {

            int moveIndex = RandomUtils.nextInt(0, elements.length);

            while (moveIndex == previousMove) {
                moveIndex = RandomUtils.nextInt(0, elements.length);
            }

            previousMove = moveIndex;

            scramble.append(randomMoveModifiers(elements[moveIndex]));

        }

        return scramble.toString();

    }

    //Generates a random move modifier and returns the move with the modifier.
    public static String randomMoveModifiers(char move) {

        int rng = RandomUtils.nextInt(0, 3);

        switch (rng){
            case 0:
                return move + "2 ";
            case 1:
                return move + "' ";
            default:
                return move + " ";

        }

    }

}
