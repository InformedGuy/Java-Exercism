import java.util.Arrays;

class LuhnValidator {

    boolean isValid(String candidate) {
        try {
            int[] cardNumber = candidate.replace(" ", "")
                    .chars()
                    .mapToObj(current -> (char) current)
                    .mapToInt(LuhnValidator::getNumber)
                    .toArray();

            return computeTotal(cardNumber) % 10 == 0;

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return false;
        }
    }

    private int computeTotal(int[] cardNumber) {
        int current = cardNumber.length - 2;

        do {
            int currentNumber = cardNumber[current] * 2;
            cardNumber[current] = (currentNumber > 9) ? currentNumber - 9 : currentNumber;

            current -= 2;
        } while (current >= 0);

        return Arrays.stream(cardNumber)
                .sum();
    }

    private static int getNumber(char current) {
        int number = Character.getNumericValue(current);

        if (number < 0 || number > 9) {
            throw new NumberFormatException();
        }

        return number;
    }

}
