class RnaTranscription {

    private static final char ADENINE = 'A';
    private static final char CYTOSINE = 'C';
    private static final char GUANINE = 'G';
    private static final char THYMINE = 'T';
    private static final char URACIL = 'U';

    String transcribe(String dnaStrand) {

        StringBuilder rnaComplement = new StringBuilder();

        for (char nucleotide : dnaStrand.toCharArray()) {
            rnaComplement.append(replaceNucleotide(nucleotide));
        }

        return rnaComplement.toString();
    }

    private char replaceNucleotide(char nucleotide) {
        return switch(nucleotide) {
            case GUANINE -> CYTOSINE;
            case CYTOSINE -> GUANINE;
            case THYMINE -> ADENINE;
            case ADENINE -> URACIL;
            default -> throw new IllegalArgumentException("Invalid DNA nucleotide");
        };
    }

}
