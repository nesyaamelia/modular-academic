package automation.helper;

import java.util.Random;

/**
 * Utility for generating random numeric values for test data.
 */
public class RandomNumber {

    private static final Random RANDOM = new Random();

    public static int getRandomInteger(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
