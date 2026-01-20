public class JedliksToyCar {

    private int distance;
    private int battery;

    public JedliksToyCar() {
        this.battery = 100;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        return (battery > 0) ? "Battery at " + battery + "%" : "Battery empty";
    }

    public void drive() {
        if (battery > 0) {
            this.distance += 20;
            this.battery--;
        }
    }
}
