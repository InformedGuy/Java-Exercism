class Scrabble {

    private String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int sum = 0;

        for (char letter : word.toCharArray()) {
            sum += getValue(letter);
        }

        return sum;
    }

    private int getValue(char c) {
        return switch (Character.toUpperCase(c)) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }

}
