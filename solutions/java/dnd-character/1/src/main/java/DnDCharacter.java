import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class DnDCharacter {

    private static final int DICE_ROLLS = 4;

    int ability(List<Integer> scores) {
        // Sort the numbers in ascending order and remove the smallest number (first number in the list)
        List<Integer> sorted = scores.stream()
                        .sorted()
                        .collect(Collectors.toList());

        sorted.removeFirst();

        return sorted.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    List<Integer> rollDice() {
        Random random = new Random();
        List<Integer> dice = new ArrayList<>();

        for (int i = 0; i < DICE_ROLLS; i++) {
            int result = random.nextInt(6) + 1;
            dice.add(result);
        }

        return dice;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0);
    }

    int getStrength() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getDexterity() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getConstitution() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getIntelligence() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getWisdom() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getCharisma() {
        List<Integer> scores = rollDice();
        return ability(scores);
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
}
