public class PangramChecker {

    public boolean isPangram(String input) {
        String lowerCase = input.toLowerCase();

        for (char character = 'a'; character <= 'z'; character++) {
            if (lowerCase.indexOf(character) == -1) {
                return false;
            }
        }

        return true;
    }

}
