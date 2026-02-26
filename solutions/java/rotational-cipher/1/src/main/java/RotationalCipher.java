import java.util.stream.IntStream;

class RotationalCipher {

    private static final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
    private static final char[] LETTERS_OF_ALPHABET;

    private final char[] caesarCipher;

    static {
        LETTERS_OF_ALPHABET = new char[NUMBER_OF_LETTERS_IN_ALPHABET];

        for (char c = 'a'; c <= 'z'; c++) {
            LETTERS_OF_ALPHABET[c - 'a'] = c;
        }
    }

    RotationalCipher(int shiftKey) {
        caesarCipher = generateCipherLetters(shiftKey);
    }

    String rotate(String data) {
        return data.chars()
                .mapToObj(c -> (char) c)
                .map(this::rotateCharacter)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private char[] generateCipherLetters(int key) {
        char[] cipher = new char[NUMBER_OF_LETTERS_IN_ALPHABET];

        for (int i = 0; i < LETTERS_OF_ALPHABET.length; i++) {
            char currentLetter = LETTERS_OF_ALPHABET[i];

            int newPosition = (i + key) % NUMBER_OF_LETTERS_IN_ALPHABET;

            cipher[newPosition] = currentLetter;
        }

        return cipher;
    }

    private char rotateCharacter(char character) {
        char lowerCase = Character.toLowerCase(character);

        int newPosition = IntStream.range(0, caesarCipher.length)
                .filter(i -> caesarCipher[i] == lowerCase)
                .findFirst()
                .orElse(-1);

        return (newPosition == -1) ? character :
                (Character.isUpperCase(character)) ?
                    Character.toUpperCase(LETTERS_OF_ALPHABET[newPosition]) :
                    LETTERS_OF_ALPHABET[newPosition];
    }

}
