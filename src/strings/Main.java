package strings;

public class Main {
    public static void main(String[] args) {
        String input = "Green brown fox jumps over a lazy dog";
        System.out.println("Vowel count -> Input: \"" + input + "\" ==> Count: " + StringUtils.countVowels(input));

        System.out.println("Reversed string -> Input: \"" + input + "\" ==> New string: " + StringUtils.reverse(input));

        System.out.println("Reversed words -> Input: \"" + input + "\" ==> New string: " + StringUtils.reverseWords(input));

        System.out.println("Reversed words (Collection) -> Input: \"" + input + "\" ==> New string: " + StringUtils.reverseWords(input));

        String input1 = "ABCD";
        String input2 = "BCDA";
        System.out.println("Checking Rotations -> Inputs: \"" + input1 + "\",\"" + input2 + "\" ==> Result: " + StringUtils.areRotations(input1, input2));

        input1 = "ABBA";
        input2 = "ABA";
        System.out.println("Checking Rotations -> Inputs: \"" + input1 + "\",\"" + input2 + "\" ==> Result: " + StringUtils.areRotations(input1, input2));

        System.out.println("Unique characters -> Input: \"" + input + "\" ==> New string: " + StringUtils.removeDuplicates(input));

        input1 = "Trees are beautiful!";
        System.out.println("Most repeated characters -> Input: \"" + input1 + "\" ==> New string: " + StringUtils.getMostRepeatedChar(input1));

        System.out.println("Most repeated characters (HashTable) -> Input: \"" + input1 + "\" ==> New string: " + StringUtils.getMostRepeatedCharUsingHashTable(input1));

        input1 = "today is a great day!";
        System.out.println("Capitalize -> Input: \"" + input1 + "\" ==> New string: " + StringUtils.capitalize(input1));
    }
}
