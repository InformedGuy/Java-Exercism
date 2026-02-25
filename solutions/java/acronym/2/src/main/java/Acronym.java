class Acronym {

    private String phrase;
    private String acronym;

    Acronym(String phrase) {
        this.phrase = phrase;
        this.acronym = generateAcronym();
    }

    private String generateAcronym() {
        StringBuilder acronym = new StringBuilder();

        String noPunctuation = phrase.replaceAll("[\\p{Punct}&&[^-]]+", "");

        String[] words = noPunctuation.split("[-\\s]+");

        for (String word : words) {
            acronym.append(word.charAt(0));
        }

        return acronym.toString().toUpperCase();
    }

    String get() {
        return acronym;
    }

}
