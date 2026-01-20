class SqueakyClean {
    static String clean(String identifier) {

        // Replace spaces with underscores
        String cleanText = identifier.replace(" ", "_");

        // Convert kebab-case to camelCase
        if (cleanText.contains("-")) {
            String[] parts = cleanText.split("-");
            StringBuilder camelCase = new StringBuilder(parts[0]);

            for (int i = 1; i < parts.length; i++) {
                char first = parts[i].charAt(0);
                char upperCase = Character.toUpperCase(first);

                StringBuilder current = new StringBuilder(parts[i]);
                current.setCharAt(0, upperCase);

                camelCase.append(current);
            }

            cleanText = camelCase.toString();
        }

        // Convert leetspeak to normal text
        cleanText = cleanText.replace('4', 'a');
        cleanText = cleanText.replace('3', 'e');
        cleanText = cleanText.replace('0', 'o');
        cleanText = cleanText.replace('1', 'l');
        cleanText = cleanText.replace('7', 't');

        // Remove all characters that are not letters or underscores
        cleanText = cleanText.replaceAll("[^a-zA-Z_]", "");

        return cleanText;

    }
}
