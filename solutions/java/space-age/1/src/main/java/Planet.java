public enum Planet {

    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132);

    private final double orbitalPeriod;

    private Planet(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public double inEarthYears() {
        return EARTH_ORBITAL_PERIOD / orbitalPeriod;
    }

    private static final double EARTH_ORBITAL_PERIOD = 1.0;

}
