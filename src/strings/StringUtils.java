package strings;

import java.util.Set;

public class StringUtils {
    public static int countVowels(String input) {
        if (input == null)
            return 0;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int vowelCount = 0;

        for (char c: input.toLowerCase().toCharArray()) {
            if (vowels.contains(c))
                vowelCount++;
        }

        return vowelCount;
    }
}
