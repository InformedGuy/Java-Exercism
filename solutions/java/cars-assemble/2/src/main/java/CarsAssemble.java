public class CarsAssemble {

    private static final int CARS_PRODUCED_AT_MINIMUM_SPEED = 221;

    public double productionRatePerHour(int speed) {
        double carsProduced = speed * CARS_PRODUCED_AT_MINIMUM_SPEED;

        if (speed == 10) {
            return carsProduced * 0.77;
        } else if (speed == 9) {
            return carsProduced * 0.8;
        } else if (speed >= 5) {
            return carsProduced * 0.9;
        }

        return carsProduced;
    }

    public int workingItemsPerMinute(int speed) {
        double carsPerHour = productionRatePerHour(speed);
        return (int) carsPerHour / 60;
    }
}
