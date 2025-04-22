package strings;

import java.util.Arrays;
import java.util.Collections;
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

    public static String reverse(String input) {
        if (input == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = input.length() - 1; i >= 0; i--)
            reversed.append(input.charAt(i));

        return reversed.toString();
    }

    public static String reverseWords(String input) {
        if (input == null)
            return "";

        String[] words = input.trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        for (var i = words.length - 1; i >= 0; i--)
            reversed.append(words[i]).append(" ");

        return reversed.toString().trim();
    }

    public static String reverseWordsUsingCollection(String input) {
        if (input == null)
            return "";

        String[] words = input.trim().split(" ");
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }
}
