public class Hamming {

    private int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        this.hammingDistance = findHammingDistance(leftStrand, rightStrand);
    }

    public int getHammingDistance() {
        return hammingDistance;
    }

    private int findHammingDistance(String leftStrand, String rightStrand) {
        try {
            int longest = Math.max(leftStrand.length(), rightStrand.length());

            int differentLetters = 0;

            for (int i = 0; i < longest; i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    differentLetters++;
                }
            }

            return differentLetters;
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }
}
