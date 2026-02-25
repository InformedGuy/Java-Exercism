class Acronym {

    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder acronym = new StringBuilder();

        String noPunctuation = phrase.replaceAll("[\\p{Punct}&&[^-]]+", "");

        String[] words = noPunctuation.split("[-\\s]+");

        for (String word : words) {
            acronym.append(word.charAt(0));
        }

        return acronym.toString().toUpperCase();
    }

}
