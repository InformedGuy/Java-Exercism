import java.util.Map;

public class Say {

    private static final long TEN = (long) 1e1;
    private static final long HUNDRED = (long) 1e2;
    private static final long THOUSAND = (long) 1e3;
    private static final long MAX_NUMBER = 999_999_999_999L;

    public String say(long number) {
        if (number < 0 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Numbers below 0 or above 999,999,999,999 are out of range");
        }

        if (number >= THOUSAND) {
            return numberInWords(number);
        }

        if (number >= HUNDRED) {
            return getHundreds(number);
        }

        if (number >= TEN) {
            return getTens(number);
        }

        return getOnes(number);
    }

    private String numberInWords(long number) {
        StringBuilder word = new StringBuilder();

        Map<Integer, String> thousandPowers = Map.of(
                1, " thousand ",
                2, " million ",
                3, " billion "
        );

        while (number >= THOUSAND) {
            int numberOfThousands = (Long.toString(number).length() - 1) / 3;
            long largestDenomination = (long) Math.pow(THOUSAND, numberOfThousands);

            long firstThreeDigits = number / largestDenomination;
            word.append(say(firstThreeDigits)).append(thousandPowers.get(numberOfThousands));

            number %= largestDenomination;
        }

        return (number == 0) ? word.toString().stripTrailing() : word.append(say(number)).toString();
    }

    private String getHundreds(long number) {
        String hundredInWords = String.join(" ", getOnes(number / HUNDRED), "hundred");

        long remainder = number % HUNDRED;

        return (remainder == 0) ? hundredInWords : String.join(" ", hundredInWords, say(remainder));
    }

    private String getTens(long number) {
        if (number % TEN == 0 || number < 20) {
            return computeTens(number);
        }

        long tens = (number / TEN) * TEN;
        long ones = number % TEN;

        return String.join("-", computeTens(tens), getOnes(ones));
    }

    private String getOnes(long number) {
        return switch ((int) number) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "Not a ones number";
        };
    }

    private String computeTens(long number) {
        return switch ((int) number) {
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "thirteen";
            case 14 -> "fourteen";
            case 15 -> "fifteen";
            case 16 -> "sixteen";
            case 17 -> "seventeen";
            case 18 -> "eighteen";
            case 19 -> "nineteen";
            case 20 -> "twenty";
            case 30 -> "thirty";
            case 40 -> "forty";
            case 50 -> "fifty";
            case 60 -> "sixty";
            case 70 -> "seventy";
            case 80 -> "eighty";
            case 90 -> "ninety";
            default -> "Not a tens number";
        };
    }
}
