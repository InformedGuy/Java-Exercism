class Darts {

    private static final double INNER_CIRCLE_RADIUS = 1.0;
    private static final double MIDDLE_CIRCLE_RADIUS = 5.0;
    private static final double OUTER_CIRCLE_RADIUS = 10.0;

    int score(double xOfDart, double yOfDart) {

        double pointRadius = Math.hypot(xOfDart, yOfDart);

        if (pointRadius > OUTER_CIRCLE_RADIUS) {
            return 0;
        } else if (pointRadius > MIDDLE_CIRCLE_RADIUS) {
            return 1;
        } else if (pointRadius > INNER_CIRCLE_RADIUS ) {
            return 5;
        }

        return 10;

    }
}
