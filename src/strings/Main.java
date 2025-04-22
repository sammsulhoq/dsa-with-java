package strings;

public class Main {
    public static void main(String[] args) {
        String inputForVowelCount = "Green brown fox jumps over a lazy dog";
        System.out.println("Vowel count -> Input: \"" + inputForVowelCount + "\", Count: " + StringUtils.countVowels(inputForVowelCount));
    }
}
