package strings;

import java.util.*;

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

    public static char getMostRepeatedChar(String input) {
        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];

        for (var ch: input.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

        return result;
    }

    public static char getMostRepeatedCharUsingHashTable(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (var ch: input.toCharArray()) {
            if (frequencies.containsKey(ch))
                frequencies.replace(ch, frequencies.get(ch) + 1);
            else
                frequencies.put(ch, 1);
        }

        return Collections.max(frequencies.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static String capitalize(String input) {
        if (input == null || input.trim().isEmpty())
            return "";

        String[] words = input.trim().replaceAll(" +", " ").split(" ");
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length())
            return false;

        var array1 = input1.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = input2.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean areAnagramsUsingHistogram(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length())
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        input1 = input1.toLowerCase();
        for (var i = 0; i < input1.length(); i++) {
            var index = input1.charAt(i) - 'a';
            frequencies[index]++;
        }

        input2 = input2.toLowerCase();
        for (var i = 0; i < input2.length(); i++) {
            var index = input2.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }
}
