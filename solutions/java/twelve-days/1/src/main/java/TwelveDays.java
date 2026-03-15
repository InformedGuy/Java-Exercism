import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TwelveDays {

    private static final String COMMON_LINES = "On the **nth** day of Christmas my true love gave to me:";
    private static final String N_TH_DAY = "**nth**";

    private final Map<Integer, String> christmasGifts;

    public TwelveDays() {
        christmasGifts = Map.ofEntries(
                Map.entry(1, "Partridge in a Pear Tree.\n"),
                Map.entry(2, "Turtle Doves"),
                Map.entry(3, "French Hens"),
                Map.entry(4, "Calling Birds"),
                Map.entry(5, "Gold Rings"),
                Map.entry(6, "Geese-a-Laying"),
                Map.entry(7, "Swans-a-Swimming"),
                Map.entry(8, "Maids-a-Milking"),
                Map.entry(9, "Ladies Dancing"),
                Map.entry(10, "Lords-a-Leaping"),
                Map.entry(11, "Pipers Piping"),
                Map.entry(12, "Drummers Drumming")
        );
    }

    String verse(int verseNumber) {
        String firstPart = COMMON_LINES.replace(N_TH_DAY, convertRankToWord(verseNumber));

        if (verseNumber == 1) {
            return String.join(" ", firstPart, convertNumberToWord(verseNumber), christmasGifts.get(1));
        }

        StringBuilder secondPart = new StringBuilder();
        int currentVerse = verseNumber;

        while (currentVerse > 0) {
            if (currentVerse == 1) {
                String verse = String.join(" ", ",", "and", convertNumberToWord(currentVerse), christmasGifts.get(currentVerse));
                secondPart.append(verse);
            } else {
                String verse = String.join(" ", convertNumberToWord(currentVerse), christmasGifts.get(currentVerse));

                if (currentVerse == verseNumber) {
                    secondPart.append(verse);
                } else {
                    secondPart.append(", ").append(verse);
                }
            }

            currentVerse--;
        }

        return String.join(" ", firstPart, secondPart.toString());
    }

    String verses(int startVerse, int endVerse) {
        List<String> songVerses = new ArrayList<>();

        for (int i = startVerse; i <= endVerse; i++) {
            songVerses.add(verse(i));
        }

        return String.join("\n", songVerses);
    }
    
    String sing() {
        return verses(1, 12);
    }

    private String convertRankToWord(int number) {
        return switch (number) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            case 4 -> "fourth";
            case 5 -> "fifth";
            case 6 -> "sixth";
            case 7 -> "seventh";
            case 8 -> "eighth";
            case 9 -> "ninth";
            case 10 -> "tenth";
            case 11 -> "eleventh";
            case 12 -> "twelfth";
            default -> throw new IllegalArgumentException("Number must be within the range 1 - 12!");
        };
    }

    private String convertNumberToWord(int number) {
        return switch(number) {
            case 1 -> "a";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            default -> throw new IllegalArgumentException("Number must be within the range 1 - 12!");
        };
    }
}
