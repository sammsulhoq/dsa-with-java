package strings;

public class Main {
    public static void main(String[] args) {
        String input = "Green brown fox jumps over a lazy dog";
        System.out.println("Vowel count -> Input: \"" + input + "\", Count: " + StringUtils.countVowels(input));

        System.out.println("Reversed string -> Input: \"" + input + "\", New string: " + StringUtils.reverse(input));

        System.out.println("Reversed words -> Input: \"" + input + "\", New string: " + StringUtils.reverseWords(input));

        System.out.println("Reversed words (Collection) -> Input: \"" + input + "\", New string: " + StringUtils.reverseWords(input));
    }
}
