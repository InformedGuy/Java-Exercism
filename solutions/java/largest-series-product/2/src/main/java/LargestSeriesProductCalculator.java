import java.util.ArrayList;
import java.util.List;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        isInputNumberValid(inputNumber);

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        isInputNumberValid(numberOfDigits);

        List<String> series = splitInputNumber(numberOfDigits);
        long maxProduct = 0;

        for (String each : series) {
            long product = each.chars()
                    .mapToLong(number -> number - '0')
                    .reduce(1, (a, b) -> a * b);

            maxProduct = Math.max(maxProduct, product);
        }

        return maxProduct;
    }

    private List<String> splitInputNumber(int span) {
        List<String> series = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            if (i + span > inputNumber.length()) {
                break;
            }

            String currentSeries = inputNumber.substring(i, i + span);
            series.add(currentSeries);
        }

        return series;
    }

    private void isInputNumberValid(int span) {
        if (span > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (span < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
    }

    private void isInputNumberValid(String input) {
        if (!input.matches("\\d+|^$")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }
}
