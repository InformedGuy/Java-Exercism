class SpaceAge {

    private static final long SECONDS_IN_ONE_EARTH_YEAR = 31_557_600L;
    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onEarth() {
        return seconds / SECONDS_IN_ONE_EARTH_YEAR;
    }

    double onMercury() {
        return onEarth() / Planet.MERCURY.getOrbitalPeriod();
    }

    double onVenus() {
        return onEarth() / Planet.VENUS.getOrbitalPeriod();
    }

    double onMars() {
        return onEarth() / Planet.MARS.getOrbitalPeriod();
    }

    double onJupiter() {
        return onEarth() / Planet.JUPITER.getOrbitalPeriod();
    }

    double onSaturn() {
        return onEarth() / Planet.SATURN.getOrbitalPeriod();
    }

    double onUranus() {
        return onEarth() / Planet.URANUS.getOrbitalPeriod();
    }

    double onNeptune() {
        return onEarth() / Planet.NEPTUNE.getOrbitalPeriod();
    }

}
