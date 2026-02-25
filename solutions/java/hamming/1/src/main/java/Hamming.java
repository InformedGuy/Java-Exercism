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
            char[] left = leftStrand.toCharArray();
            char[] right = rightStrand.toCharArray();

            int longest = Math.max(left.length, right.length);

            int differentLetters = 0;

            for (int i = 0; i < longest; i++) {
                if (left[i] != right[i]) {
                    differentLetters++;
                }
            }

            return differentLetters;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }
}
