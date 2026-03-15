import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private static final String COMMON_LINES = "On the **nth** day of Christmas my true love gave to me";
    private static final String N_TH_DAY = "**nth**";

    private final Map<Integer, String> christmasGifts;

    public TwelveDays() {
        christmasGifts = Map.ofEntries(
                Map.entry(1, "a Partridge in a Pear Tree.\n"),
                Map.entry(2, "two Turtle Doves"),
                Map.entry(3, "three French Hens"),
                Map.entry(4, "four Calling Birds"),
                Map.entry(5, "five Gold Rings"),
                Map.entry(6, "six Geese-a-Laying"),
                Map.entry(7, "seven Swans-a-Swimming"),
                Map.entry(8, "eight Maids-a-Milking"),
                Map.entry(9, "nine Ladies Dancing"),
                Map.entry(10, "ten Lords-a-Leaping"),
                Map.entry(11, "eleven Pipers Piping"),
                Map.entry(12, "twelve Drummers Drumming")
        );
    }

    String verse(int verseNumber) {
        String firstPart = COMMON_LINES.replace(N_TH_DAY, convertRankToWord(verseNumber));
        String secondPart;

        if (verseNumber > 1) {
            String gifts = IntStream.rangeClosed(1, verseNumber)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .filter(number -> number > 1)
                    .map(christmasGifts::get)
                    .collect(Collectors.joining(", ", "", ","));

            secondPart = String.join(" ", gifts, "and", christmasGifts.get(1));
        } else {
            secondPart = christmasGifts.get(1);
        }

        return String.join(": ", firstPart, secondPart);
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
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
}
