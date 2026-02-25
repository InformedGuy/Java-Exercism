import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class ProteinTranslator {

    private Map<String, String> aminoAcids;

    public ProteinTranslator() {
        this.aminoAcids = Map.of(
                "Methionine", "AUG",
                "Phenylalanine", "UUU-UUC",
                "Leucine", "UUA-UUG",
                "Serine", "UCU-UCC-UCA-UCG",
                "Tyrosine", "UAU-UAC",
                "Cysteine", "UGU-UGC",
                "Tryptophan", "UGG",
                "STOP", "UAA-UAG-UGA"
        );
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

            Optional<String> currentProtein = getAminoAcid(rnaSequence.substring(i, i + 3));

            if (currentProtein.isEmpty()) {
                throw new IllegalArgumentException("Invalid codon");
            } else if (currentProtein.get().equals("STOP")) {
                break;
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
