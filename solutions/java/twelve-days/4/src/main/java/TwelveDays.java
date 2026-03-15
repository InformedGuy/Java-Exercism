import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private static final String COMMON_LINES = "On the %s day of Christmas my true love gave to me";

    private static final Map<Integer, String> CHRISTMAS_GIFTS = Map.ofEntries(
            Map.entry(1, "a Partridge in a Pear Tree"),
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

    String verse(int verseNumber) {
        String firstPart = COMMON_LINES.formatted(convertRankToWord(verseNumber));

        String secondPart = (verseNumber > 1) ?
                getVerse(verseNumber).concat(CHRISTMAS_GIFTS.get(1)) : CHRISTMAS_GIFTS.get(1);

        return String.join(": ", firstPart, secondPart).concat(".\n");
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }
    
    String sing() {
        return verses(1, 12);
    }

    private String getVerse(int verseNumber) {
        return IntStream.iterate(verseNumber, i -> i - 1)
                .limit(verseNumber - 1)
                .mapToObj(CHRISTMAS_GIFTS::get)
                .collect(Collectors.joining(", ", "", ", and "));
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
