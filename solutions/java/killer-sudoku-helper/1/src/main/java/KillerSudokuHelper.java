import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> possibleCombinations = combinationsInCage(cageSum, cageSize);

        List<List<Integer>> validCombinations = new ArrayList<>();

        for (List<Integer> combination : possibleCombinations) {
            if (Collections.disjoint(combination, exclude)) {
                validCombinations.add(combination);
            }
        }

        return validCombinations;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        if (cageSize < 3) {
            return lessThanThreeDigits(cageSum, cageSize);
        }

        List<List<Integer>> cage = new ArrayList<>();

        if (isTriangularNumber(cageSum, cageSize)) {
            List<Integer> combination = IntStream.rangeClosed(1, cageSize)
                    .boxed()
                    .toList();

            cage.add(combination);
            return cage;
        }

        return new ArrayList<>();

    }

    private List<List<Integer>> lessThanThreeDigits(Integer cageSum, Integer cageSize) {
        if (cageSize == 1) {
            return List.of(List.of(cageSum));
        }

        List<List<Integer>> cage = new ArrayList<>();

        Set<Integer> presentNumbers = new HashSet<>();

        for (int i = 1; i <= 5; i++) {
            int otherNumber = cageSum - i;

            if (otherNumber > 9 || otherNumber < 1) {
                continue;
            }

            if (i == otherNumber || !presentNumbers.add(otherNumber) || !presentNumbers.add(i)) {
                break;
            }

            cage.add(List.of(i, otherNumber));
        }

        return cage;

    }

    private boolean isTriangularNumber(Integer cageSum, Integer cageSize) {
        return IntStream.rangeClosed(1, cageSize).sum() == cageSum;
    }

}
