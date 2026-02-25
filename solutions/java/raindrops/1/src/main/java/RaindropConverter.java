class RaindropConverter {

    private static final String PLING = "Pling";
    private static final String PLANG = "Plang";
    private static final String PLONG = "Plong";

    String convert(int number) {
        if (number % 3 != 0 && number % 5 != 0 && number % 7 != 0) {
            return Integer.toString(number);
        }

        StringBuilder sounds = new StringBuilder();

        if (number % 3 == 0) {
            sounds.append(PLING);
        }

        if (number % 5 == 0) {
            sounds.append(PLANG);
        }

        if (number % 7 == 0) {
            sounds.append(PLONG);
        }

        return sounds.toString();
    }

}
