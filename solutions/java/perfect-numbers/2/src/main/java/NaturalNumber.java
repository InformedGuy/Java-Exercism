import java.util.HashSet;
import java.util.Set;

class NaturalNumber {

    private int number;

    NaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.number = number;
    }

    Classification getClassification() {
        int aliquotSum = computeAliquotSum();

        if (aliquotSum == number) {
            return Classification.PERFECT;
        } else if (aliquotSum > number) {
            return Classification.ABUNDANT;
        }

        return Classification.DEFICIENT;
    }

    public int computeAliquotSum() {
        Set<Integer> factors = new HashSet<>();

        int step = (number % 2 == 0) ? 1 : 2; // If number is odd, then all its factors must be odd

        int limit = (int) Math.sqrt(number);

        for (int i = 1; i <= limit; i += step) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number / i);
            }
        }

        return factors.stream()
                .filter(num -> num != number)
                .reduce(0, Integer::sum);
    }
}
