public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int minutesSpentInOven) {
        return expectedMinutesInOven() - minutesSpentInOven;
    }

    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    public int totalTimeInMinutes(int layers, int minutesSpentInOven) {
        return preparationTimeInMinutes(layers) + minutesSpentInOven;
    }
}
