import java.util.Arrays;

class LuhnValidator {

    boolean isValid(String candidate) {
        String identifier = candidate.replace(" ", "");

        try {
            int[] cardNumber = identifier.chars()
                    .map(character -> {
                        int number = Character.getNumericValue(character);

                        if (number < 0 || number > 9) {
                            throw new NumberFormatException();
                        }

                        return number;
                    })
                    .toArray();

            int current = identifier.length() - 2;

            do {
                int currentNumber = cardNumber[current] * 2;
                cardNumber[current] = (currentNumber > 9) ? currentNumber - 9 : currentNumber;

                current -= 2;
            } while (current >= 0);

            return Arrays.stream(cardNumber)
                    .sum() % 10 == 0;

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return false;
        }
    }

}
