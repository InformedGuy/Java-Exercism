import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        } else {
            BigInteger base = BigInteger.valueOf(2);
            return base.pow(square - 1);
        }
    }

    BigInteger grainsOnBoard() {
        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 1; i <= 64; i++) {
            sum = sum.add(grainsOnSquare(i));
        }

        return sum;
    }

}
