import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!isInputNumberValid(inputNumber)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        isInputNumberValid(numberOfDigits);

        List<String> series = splitInputNumber(numberOfDigits);
        Map<String, Long> seriesProduct = new HashMap<>();

        for (String each : series) {
            long product = each.chars()
                    .mapToLong(number -> number - '0')
                    .reduce(1, (a, b) -> a * b);

            seriesProduct.put(each, product);
        }

        Optional<Map.Entry<String, Long>> maxProduct = seriesProduct.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        if (maxProduct.isPresent()) {
            return maxProduct.get().getValue();
        }

        return -1;
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

    private boolean isInputNumberValid(String input) {
       return input.matches("\\d+|^$");
    }
}
