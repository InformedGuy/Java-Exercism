class MicroBlog {

    private static final int MAX_CHARACTERS = 5;

    public String truncate(String input) {
        int numberOfCharacters = input.codePointCount(0, input.length());
        int lastIndex = input.offsetByCodePoints(0, Math.min(numberOfCharacters, MAX_CHARACTERS));
        return input.substring(0, lastIndex);
    }
}
