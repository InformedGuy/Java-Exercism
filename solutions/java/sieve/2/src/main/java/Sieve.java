import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Sieve {

    private final int maxNumber;

    Sieve(int maxPrime) {
        this.maxNumber = maxPrime;
    }

    List<Integer> getPrimes() {
        boolean[] isPrime = findPrimes();

        return IntStream.range(0, isPrime.length)
                .filter(i -> isPrime[i])
                .boxed()
                .toList();
    }

    private boolean[] findPrimes() {
        boolean[] isPrime = new boolean[maxNumber + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(maxNumber); i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
