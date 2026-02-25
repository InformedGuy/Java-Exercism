class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder proverb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                proverb.append("And all for the want of a ").append(words[0]).append(".");
            } else {
                proverb.append("For want of a ").append(words[i]).append(" the ").append(words[i + 1]).append(" was lost.\n");
            }
        }

        return proverb.toString();
    }

}
