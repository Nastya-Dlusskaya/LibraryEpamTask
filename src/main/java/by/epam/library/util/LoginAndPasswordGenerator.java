package by.epam.library.util;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class LoginAndPasswordGenerator {

    private static final char MINIMUM_RANGE = '0';
    private static final char MAXIMUM_RANGE = 'z';

    public static String createRandomString(int minLengthString, int maxLengthString){
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange(MINIMUM_RANGE, MAXIMUM_RANGE)
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();
        return randomStringGenerator.generate(minLengthString, maxLengthString);
    }
}
