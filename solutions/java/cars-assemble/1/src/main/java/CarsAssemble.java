public class CarsAssemble {

    private static final int CARS_PRODUCED_AT_MINIMUM_SPEED = 221;

    public double productionRatePerHour(int speed) {
        double carsProduced = speed * CARS_PRODUCED_AT_MINIMUM_SPEED;
        if (speed >= 1 && speed <= 10) {
            if (speed <= 4) {
                return carsProduced;
            } else if (speed <= 8) {
                return carsProduced * 0.9;
            } else if (speed == 9) {
                return carsProduced * 0.8;
            } else {
                return carsProduced * 0.77;
            }
        } else {
            return 0.0;
        }
    }

    public int workingItemsPerMinute(int speed) {
        double carsPerHour = productionRatePerHour(speed);
        return (int) carsPerHour / 60;
    }
}
