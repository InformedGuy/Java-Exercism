import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RateLimiter<K> {

    private final int limit;
    private final Duration windowSize;
    private final TimeSource timeSource;
    private Instant startOfInterval;
    private Map<K, Integer> clientRequests;

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timeSource = timeSource;
        this.startOfInterval = this.timeSource.now();
        this.clientRequests = new HashMap<>();
    }

    public boolean allow(K clientId) {
        if (hasIntervalElapsed()) {
            timeSource.advance(windowSize);
            startOfInterval = timeSource.now();

            clientRequests.replaceAll((key, value) -> 0);
            clientRequests.put(clientId, 1);

            return true;
        }

        Optional<Integer> numberOfRequests = Optional.ofNullable(clientRequests.get(clientId));

        if (numberOfRequests.isEmpty() || numberOfRequests.get() < limit) {
            clientRequests.merge(clientId, 1, Integer::sum);
            return true;
        }

        return false;
    }

    private boolean hasIntervalElapsed() {
        Instant now = timeSource.now();
        Duration timeElapsed = Duration.between(startOfInterval, now);

        return timeElapsed.compareTo(windowSize) >= 0;
    }
}
