import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    private List<Integer> primeNumbers = new ArrayList<>();

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        // Start at the first prime number, which is 2
        int currentNumber = 2;

        while (primeNumbers.size() < nth) {
            if (isPrimeNumber(currentNumber)) {
                primeNumbers.add(currentNumber);
            }

            currentNumber++;
        }

        return primeNumbers.getLast();
    }

    private boolean isPrimeNumber(int number) {
        return primeNumbers.stream()
                .filter(prime -> prime <= Math.sqrt(number))
                .noneMatch(prime -> number % prime == 0);

    }

}
