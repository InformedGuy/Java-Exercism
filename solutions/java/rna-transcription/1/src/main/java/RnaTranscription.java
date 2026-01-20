class RnaTranscription {

    private static final char ADENINE = 'A';
    private static final char CYTOSINE = 'C';
    private static final char GUANINE = 'G';
    private static final char THYMINE = 'T';
    private static final char URACIL = 'U';

    String transcribe(String dnaStrand) {
        char[] nucleotides = dnaStrand.toCharArray();

        for (int i = 0; i < nucleotides.length; i++) {
            char complementNucleotide = replaceNucleotide(nucleotides[i]);
            nucleotides[i] = complementNucleotide;
        }

        return new String(nucleotides);
    }

    private char replaceNucleotide(char nucleotide) {
        return switch(nucleotide) {
            case GUANINE -> CYTOSINE;
            case CYTOSINE -> GUANINE;
            case THYMINE -> ADENINE;
            case ADENINE -> URACIL;
            default -> nucleotide;
        };
    }

}
