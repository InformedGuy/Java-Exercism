import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
    private final int hitPoints;

    public DnDCharacter() {
        strength = ability(rollDice());
        dexterity = ability(rollDice());
        constitution = ability(rollDice());
        intelligence = ability(rollDice());
        wisdom = ability(rollDice());
        charisma = ability(rollDice());
        hitPoints = 10 + modifier(constitution);
    }

    int ability(List<Integer> scores) {
        return scores.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    List<Integer> rollDice() {
        Random random = new Random();
        List<Integer> dice = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_DICE_ROLLS; i++) {
            dice.add(random.nextInt(SMALLEST_DICE, LARGEST_DICE + 1));
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
        return hitPoints;
    }
}
