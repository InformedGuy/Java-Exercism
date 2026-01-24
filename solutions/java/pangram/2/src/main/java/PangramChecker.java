public class PangramChecker {

    private static final int LETTERS_OF_ALPHABET = 26;

    public boolean isPangram(String input) {
        return input.toLowerCase().chars()
                .filter(Character::isLetter)
                .distinct()
                .count() == LETTERS_OF_ALPHABET;
    }

}
