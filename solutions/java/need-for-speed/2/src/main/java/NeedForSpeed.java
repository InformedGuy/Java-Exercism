class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;
    private int distanceCovered;
    private int battery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return distanceCovered;
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceCovered += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while (distance > car.distanceDriven() && !car.batteryDrained()) {
            car.drive();
        }

        return distance >= car.distanceDriven();
    }
}
