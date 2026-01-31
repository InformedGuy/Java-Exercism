import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IsbnVerifier {

    private static final int TEN = 10;

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replace("-", "");

        if (!isPatternValid(stringToVerify)) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < TEN; i++) {
            char current = stringToVerify.charAt(i);
            int digit = (Character.isDigit(current)) ? Character.getNumericValue(current) : TEN;

            sum += digit * (TEN - i);
        }

        return sum % 11 == 0;

    }

    private boolean isPatternValid(String input) {
        /*
        * A valid ISBN-10 number is made up of 10 characters
        * First 9 characters should be numeric and last character can be numeric or letter 'x'
        */

        Pattern validPattern = Pattern.compile("^\\d{9}[\\dx]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validPattern.matcher(input);
        return matcher.find();
    }

}
