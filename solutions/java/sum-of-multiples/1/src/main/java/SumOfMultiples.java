import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class SumOfMultiples {

    int[] range;
    int[] set;

    SumOfMultiples(int number, int[] set) {
        this.range = IntStream.range(1, number)
                .toArray();
        this.set = set;
    }

    int getSum() {
        return findMultiples().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Set<Integer> findMultiples() {
        Set<Integer> multiples = new HashSet<>();

        for (int number : set) {
            if (number == 0) {
                continue;
            }

            Integer[] valid = Arrays.stream(range)
                    .filter(num -> num % number == 0)
                    .boxed()
                    .toArray(Integer[]::new);

            Collections.addAll(multiples, valid);
        }

        return multiples;
    }

}
