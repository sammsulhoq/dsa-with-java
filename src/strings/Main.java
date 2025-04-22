package strings;

public class Main {
    public static void main(String[] args) {
        String input = "Green brown fox jumps over a lazy dog";
        System.out.println("Vowel count -> Input: \"" + input + "\", Count: " + StringUtils.countVowels(input));

        System.out.println("Reversed string -> Input: \"" + input + "\", New string: " + StringUtils.reverse(input));
    }
}
