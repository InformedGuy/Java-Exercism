import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KillerSudokuHelper {

    private List<List<Integer>> combinations;

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        int maxNumber = Math.min(cageSum, 9);
        int[] range = IntStream.rangeClosed(1, maxNumber)
                .filter(number -> !exclude.contains(number))
                .toArray();

        combinations = new ArrayList<>();

        generateCombinations(range, 0, new ArrayList<>(), cageSum, cageSize);

        return combinations;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, List.of());
    }

    private void generateCombinations(int[] arr, int index, List<Integer> currentCombination, int targetSum, int length) {
        int sum = currentCombination.stream().mapToInt(Integer::intValue).sum();

        if (currentCombination.size() == length) {
            if (sum == targetSum) {
                combinations.add(new ArrayList<>(currentCombination));
            }

            return;
        }

        int remainingDigits = currentCombination.size() + (arr.length - index);
        int remainingSum = Arrays.stream(arr, index, arr.length)
                .sum() + sum;

        if (sum > targetSum || index >= arr.length || remainingDigits < length || remainingSum < targetSum) {
            return;
        }

        currentCombination.add(arr[index]);
        generateCombinations(arr, index + 1, currentCombination, targetSum, length);

        currentCombination.removeLast();
        generateCombinations(arr, index + 1, currentCombination, targetSum, length);
    }

}
