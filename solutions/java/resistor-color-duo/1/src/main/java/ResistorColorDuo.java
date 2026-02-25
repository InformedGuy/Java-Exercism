import java.util.HashMap;
import java.util.Map;

class ResistorColorDuo {

    private Map<String, Integer> resistorColors;

    public ResistorColorDuo() {
        this.resistorColors = new HashMap<>();
        addColors();
    }

    private void addColors() {
        resistorColors.put("black", 0);
        resistorColors.put("brown", 1);
        resistorColors.put("red", 2);
        resistorColors.put("orange", 3);
        resistorColors.put("yellow", 4);
        resistorColors.put("green", 5);
        resistorColors.put("blue", 6);
        resistorColors.put("violet", 7);
        resistorColors.put("grey", 8);
        resistorColors.put("white", 9);
    }

    int value(String[] colors) {
        return 10 * resistorColors.get(colors[0]) + resistorColors.get(colors[1]);
    }
}
