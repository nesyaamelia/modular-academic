package automation.helper;

import java.util.Random;

/**
 * Utility for generating random string data used in test models.
 */
public class StringHelper {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();

    public static String generateRandomLowercase(int length) {
        return generate(LOWERCASE, length);
    }

    public static String generateRandomUppercase(int length) {
        return generate(UPPERCASE, length);
    }

    private static String generate(String chars, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
