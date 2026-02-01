class IsogramChecker {

    boolean isIsogram(String phrase) {
        String clean = phrase.toLowerCase().replaceAll("[-\\s]", "");
        return clean.length() == clean.chars().distinct().count();
    }

}
