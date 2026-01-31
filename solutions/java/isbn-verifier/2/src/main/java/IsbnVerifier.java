import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String clean = stringToVerify.replace("-", "");

        return isPatternValid(clean) && IntStream.range(0, 10)
                .map(index -> {
                    char character = clean.charAt(index);
                    int digit = (Character.isDigit(character)) ? Character.getNumericValue(character) : 10;
                    return digit * (10 - index);
                })
                .sum() % 11 == 0;

    }

    private boolean isPatternValid(String input) {
        Pattern validPattern = Pattern.compile("^\\d{9}[\\dx]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validPattern.matcher(input);
        return matcher.find();
    }

}
