import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stopwatch {

    private static final long SECONDS_IN_ONE_HOUR = 3600;
    private static final long SECONDS_IN_ONE_MINUTE = 60;

    private final List<Duration> intervals = new ArrayList<>();
    private final List<Duration> totalIntervals = new ArrayList<>();

    private Instant startTime;
    private boolean isIntervalTracked;

    public void start() {
        if (!isIntervalTracked) {
            startTime = Instant.now();
            isIntervalTracked = true;
        }
    }

    public void stop() {
        if (isIntervalTracked) {
            Instant now = Instant.now();

            Duration elapsedTime = Duration.between(startTime, now);
            intervals.add(elapsedTime);
            totalIntervals.add(elapsedTime);

            isIntervalTracked = false;
        }
    }

    public String getLap() {
        return computeLap(intervals);
    }

    public String getTotal() {
        return computeLap(totalIntervals);
    }

    private String computeLap(List<Duration> currentLap) {
        long seconds = currentLap.stream()
                .mapToLong(Duration::getSeconds)
                .sum();

        long hours = seconds / SECONDS_IN_ONE_HOUR;
        seconds %= SECONDS_IN_ONE_HOUR;

        long minutes = seconds / SECONDS_IN_ONE_MINUTE;
        seconds %= SECONDS_IN_ONE_MINUTE;

        List<Long> timeTaken = List.of(hours, minutes, seconds);
        DecimalFormat decimalFormat = new DecimalFormat("00");

        return timeTaken.stream()
                .map(decimalFormat::format)
                .collect(Collectors.joining(":"));
    }

    public void reset() {
        intervals.clear();
    }

    public void advanceTime(String timeString) {
        if (isIntervalTracked) {
            String[] time = timeString.split(":");

            long hours = Long.parseLong(time[0]);
            long minutes = Long.parseLong(time[1]);
            long seconds = Long.parseLong(time[2]);

            seconds += hours * SECONDS_IN_ONE_HOUR;
            seconds += minutes * SECONDS_IN_ONE_MINUTE;

            Duration advanced = Duration.ofSeconds(seconds);
            intervals.add(advanced);
            totalIntervals.add(advanced);
        }
    }

}
