import java.util.Map;

class ResistorColorTrio {

    private static final int KILO = (int) Math.pow(10, 3);
    private static final int MEGA = (int) Math.pow(10, 6);
    private static final int GIGA = (int) Math.pow(10, 9);

    private Map<String, Integer> resistorColors;

    public ResistorColorTrio() {
        this.resistorColors = Map.of(
                "black", 0,
                "brown", 1,
                "red", 2,
                "orange", 3,
                "yellow", 4,
                "green", 5,
                "blue", 6,
                "violet", 7,
                "grey", 8,
                "white", 9
        );
    }

    String label(String[] colors) {
        long ohms = getValue(colors);

        if (ohms >= GIGA) {
            return ohms / GIGA + " gigaohms";
        } else if (ohms >= MEGA) {
            return ohms / MEGA + " megaohms";
        } else if (ohms >= KILO) {
            return ohms / KILO + " kiloohms";
        }

        return ohms + " ohms";
    }

    private long getValue(String[] colors) {
        int value = 10 * resistorColors.get(colors[0]) + resistorColors.get(colors[1]);
        return ((long) Math.pow(10, resistorColors.get(colors[2]))) * value;
    }

}
