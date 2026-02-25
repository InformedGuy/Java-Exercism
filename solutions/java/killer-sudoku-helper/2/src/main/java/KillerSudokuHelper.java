import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class KillerSudokuHelper {

    private final List<List<Integer>> combinations;

    public KillerSudokuHelper() {
        this.combinations = new ArrayList<>();
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> possibleCombinations = combinationsInCage(cageSum, cageSize);

        return possibleCombinations.stream()
                .filter(currentCombination -> Collections.disjoint(currentCombination, exclude))
                .toList();
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        int maxNumber = Math.min(cageSum, 9);
        int[] range = IntStream.rangeClosed(1, maxNumber).toArray();

        generateCombinations(range, 0, new ArrayList<>());

        return combinations.stream()
                .filter(currentCombination -> currentCombination.size() == cageSize &&
                        currentCombination.stream().mapToInt(Integer::intValue).sum() == cageSum)
                .toList();
    }

    private void generateCombinations(int[] arr, int index, List<Integer> currentCombination) {
        if (index == arr.length) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // Include the current element
        currentCombination.add(arr[index]);
        generateCombinations(arr, index + 1, currentCombination);

        // Exclude the current element
        currentCombination.removeLast();
        generateCombinations(arr, index + 1, currentCombination);

    }

}
