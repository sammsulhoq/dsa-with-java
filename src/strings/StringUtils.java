package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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

    /**
     * Concatenating the first input with itself and then comparing it with second input
     * verifies if the second one is rotation or not since it will be inside the concatenated
     * result
     * Also, both the string should be of same length
     * e.g.: ABCD -> DABC
     *            -> CDAB
     *            -> BCDA
     *            -> ABCD
     *  ABCDABCD contains second input BCDA, thus proving that it's a rotation
     * @param input1    String input a feed
     * @param input2    String input to be checked for rotation
     * @return  true if the second word is rotation of first otherwise returns false
     */
    public static boolean areRotations(String input1, String input2) {
        if (input1 == null || input2 == null)
            return false;

        return ((input1.length() == input2.length()) && (input1 + input1).contains(input2));
    }

    public static String removeDuplicates(String input) {
        if (input == null)
            return "";

        StringBuilder newString = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (var ch: input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                newString.append(ch);
            }
        }

        return newString.toString();
    }
}
