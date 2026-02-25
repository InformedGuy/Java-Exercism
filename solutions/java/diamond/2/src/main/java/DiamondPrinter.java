import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    private static final char LETTER_A = 'A';

    List<String> printToList(char a) {
        List<String> diamond = new ArrayList<>();

        if (!Character.isLetter(a)) {
            return diamond;
        }

        char character = Character.toUpperCase(a);

        int diamondWidth = 2 * (character - LETTER_A) + 1;
        int center = diamondWidth / 2;

        for (char letter = LETTER_A; letter <= character; letter++) {
            char[] row = new char[diamondWidth];
            Arrays.fill(row, ' ');

            int letterIndex = letter - LETTER_A;
            row[center - letterIndex] = letter;
            row[center + letterIndex] = letter;

            diamond.add(new String(row));
        }

        List<String> bottomHalf = diamond.reversed()
                .stream()
                .filter(row -> !row.contains(String.valueOf(character)))
                .toList();

        diamond.addAll(bottomHalf);

        return diamond;
    }

}