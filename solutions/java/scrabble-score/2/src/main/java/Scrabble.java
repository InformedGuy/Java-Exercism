class Scrabble {

    private final int score;

    Scrabble(String word) {
        word = word.toUpperCase();
        int score = 0;

        for (char letter : word.toCharArray()) {
            score += getValue(letter);
        }

        this.score = score;
    }

    int getScore() {
        return score;
    }

    private int getValue(char character) {
        return switch (character) {
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
