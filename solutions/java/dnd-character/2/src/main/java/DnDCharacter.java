import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class DnDCharacter {

    private static final int NUMBER_OF_DICE_ROLLS = 4;
    private static final int SMALLEST_DICE = 1;
    private static final int LARGEST_DICE = 6;

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter() {
        strength = ability(rollDice());
        dexterity = ability(rollDice());
        constitution = ability(rollDice());
        intelligence = ability(rollDice());
        wisdom = ability(rollDice());
        charisma = ability(rollDice());
    }

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

        for (int i = 0; i < NUMBER_OF_DICE_ROLLS; i++) {
            int result = random.nextInt(SMALLEST_DICE, LARGEST_DICE + 1);
            dice.add(result);
        }

        return dice;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
}
