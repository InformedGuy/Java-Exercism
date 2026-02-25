class SpaceAge {

    private static final long SECONDS_IN_ONE_EARTH_YEAR = 31_557_600L;
    private final double earthYears;

    SpaceAge(double seconds) {
        this.earthYears = seconds / SECONDS_IN_ONE_EARTH_YEAR;
    }

    double getSeconds() {
        return earthYears;
    }

    double onEarth() {
        return getSeconds();
    }

    double onMercury() {
        return getSeconds() * Planet.MERCURY.inEarthYears();
    }

    double onVenus() {
        return getSeconds() * Planet.VENUS.inEarthYears();
    }

    double onMars() {
        return getSeconds() * Planet.MARS.inEarthYears();
    }

    double onJupiter() {
        return getSeconds() * Planet.JUPITER.inEarthYears();
    }

    double onSaturn() {
        return getSeconds() * Planet.SATURN.inEarthYears();
    }

    double onUranus() {
        return getSeconds() * Planet.URANUS.inEarthYears();
    }

    double onNeptune() {
        return getSeconds() * Planet.NEPTUNE.inEarthYears();
    }

}
