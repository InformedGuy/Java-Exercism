import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

class VariableLengthQuantity {

    private static final long ONE_TWENTY_EIGHT = 128;
    private static final String HEX_PREFIX = "0x";

    List<String> encode(List<Long> numbers) {
        return numbers.stream()
                .map(VariableLengthQuantity::getEncoded)
                .flatMap(List::stream)
                .toList();
    }

    List<String> decode(List<Long> bytes) {
        List<List<Long>> encodedNumbers = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        Iterator<Long> it = bytes.iterator();

        while (it.hasNext()) {
            long currentByte = it.next();
            numbers.add(currentByte);

            if (currentByte < ONE_TWENTY_EIGHT) {
                encodedNumbers.add(new ArrayList<>(numbers));
                numbers.clear();
                continue;
            }

            if (!it.hasNext()) {
                throw new IllegalArgumentException("Invalid variable-length quantity encoding");
            }
        }

        return encodedNumbers.stream()
                .map(VariableLengthQuantity::getDecoded)
                .toList();
    }

    private static List<String> getEncoded(Long number) {
        List<Long> encodedNumbers = new ArrayList<>();
        long quotient = number;

        do {
            encodedNumbers.add(quotient % ONE_TWENTY_EIGHT);
            quotient /= ONE_TWENTY_EIGHT;
        } while (quotient > 0);

        Collections.reverse(encodedNumbers);

        return IntStream.range(0, encodedNumbers.size())
                .mapToLong(index -> {
                    if (index == encodedNumbers.size() - 1) {
                        return encodedNumbers.get(index);
                    }

                    return encodedNumbers.get(index) + ONE_TWENTY_EIGHT;
                })
                .mapToObj(VariableLengthQuantity::getHexString)
                .toList();
    }

    private static String getDecoded(List<Long> encodedNumbers) {
        long decodedNumber = encodedNumbers.stream()
                .reduce(0L, (result, number) -> result * ONE_TWENTY_EIGHT + number % ONE_TWENTY_EIGHT);

        return getHexString(decodedNumber);
    }

    private static String getHexString(Long number) {
        return HEX_PREFIX + Long.toHexString(number);
    }
}
