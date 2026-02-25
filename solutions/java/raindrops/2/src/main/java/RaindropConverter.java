class RaindropConverter {

    String convert(int number) {
        StringBuilder sounds = new StringBuilder();

        if (number % 3 == 0) {
            sounds.append("Pling");
        }

        if (number % 5 == 0) {
            sounds.append("Plang");
        }

        if (number % 7 == 0) {
            sounds.append("Plong");
        }

        return (sounds.isEmpty()) ? Integer.toString(number) : sounds.toString();
    }

}
