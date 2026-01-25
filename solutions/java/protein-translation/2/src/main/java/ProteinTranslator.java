import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class ProteinTranslator {

    private Map<String, String> aminoAcids;
    private List<String> stop;

    public ProteinTranslator() {
        this.aminoAcids = Map.of(
                "Methionine", "AUG",
                "Phenylalanine", "UUU-UUC",
                "Leucine", "UUA-UUG",
                "Serine", "UCU-UCC-UCA-UCG",
                "Tyrosine", "UAU-UAC",
                "Cysteine", "UGU-UGC",
                "Tryptophan", "UGG"
        );
        this.stop = List.of("UAA", "UAG", "UGA");
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();

        if (rnaSequence == null) {
            return proteins;
        }

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            if (i + 3 > rnaSequence.length()) {
                throw new IllegalArgumentException("Invalid codon");
            }

            String sequence = rnaSequence.substring(i, i + 3);

            Optional<String> currentProtein = getAminoAcid(sequence);

            if (currentProtein.isEmpty()) {
                if (stop.contains(sequence)) {
                    break;
                }

                throw new IllegalArgumentException("Invalid codon");
            }

            proteins.add(currentProtein.get());
        }

        return proteins;
    }

    private Optional<String> getAminoAcid(String protein) {
        return aminoAcids.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(protein))
                .map(Map.Entry::getKey)
                .findAny();
    }

}
