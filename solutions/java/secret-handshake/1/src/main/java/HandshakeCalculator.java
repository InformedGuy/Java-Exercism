import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    private static final int MASK = 0x1F;

    List<Signal> calculateHandshake(int number) {
        int lastFiveBits = number & MASK;

        List<Signal> actions = new ArrayList<>();
        Signal[] signals = Signal.values();

        for (Signal signal : signals) {
            if ((lastFiveBits & 1) == 1) {
                actions.add(signal);
            }

            lastFiveBits >>= 1;
        }

        if ((lastFiveBits & 1) == 1) {
            Collections.reverse(actions);
        }

        return actions;
    }

}
