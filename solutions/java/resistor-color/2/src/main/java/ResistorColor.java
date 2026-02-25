import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ResistorColor {

    private Map<String, Integer> resistorColors;

    public ResistorColor() {
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

    int colorCode(String color) {
        return resistorColors.get(color);
    }

    String[] colors() {
        List<String> colorsList = resistorColors.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();

        return colorsList.toArray(new String[0]);
    }
}
