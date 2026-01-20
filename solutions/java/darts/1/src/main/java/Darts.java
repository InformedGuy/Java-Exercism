class Darts {
    int score(double xOfDart, double yOfDart) {

        double distanceFromCenter = Math.hypot(Math.abs(xOfDart), Math.abs(yOfDart));

        if (distanceFromCenter <= 1) {
            return 10;
        } else if (distanceFromCenter <= 5) {
            return 5;
        } else if (distanceFromCenter <= 10) {
            return 1;
        } else {
            return 0;
        }

    }
}
