import java.util.HashSet;
import java.util.Set;

class NaturalNumber {

    private int number;
    private int aliquotSum;

    NaturalNumber(int number) {
        this.number = number;
        this.aliquotSum = computeAliquotSum();
    }

    Classification getClassification() {
        if (aliquotSum == number) {
            return Classification.PERFECT;
        } else if (aliquotSum > number) {
            return Classification.ABUNDANT;
        }

        return Classification.DEFICIENT;
    }

    public int computeAliquotSum() {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        Set<Integer> factors = new HashSet<>();

        int step = (number % 2 == 0) ? 1 : 2;

        for (int i = 1; i <= Math.sqrt(number); i += step) {
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
