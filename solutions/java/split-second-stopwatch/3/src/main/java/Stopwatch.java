import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stopwatch {

    private final List<Duration> intervals = new ArrayList<>();
    private final List<Duration> totalIntervals = new ArrayList<>();

    private Instant startTime;
    private boolean hasStartedTracking;

    public void start() {
        if (!hasStartedTracking) {
            startTime = Instant.now();
            hasStartedTracking = true;
        }
    }

    public void stop() {
        if (hasStartedTracking) {
            Instant now = Instant.now();

            Duration elapsedTime = Duration.between(startTime, now);
            intervals.add(elapsedTime);
            totalIntervals.add(elapsedTime);

            hasStartedTracking = false;
        }
    }

    public String getLap() {
        return computeLap(intervals);
    }

    public String getTotal() {
        return computeLap(totalIntervals);
    }

    private String computeLap(List<Duration> currentLap) {
        long totalLapTime = currentLap.stream()
                .mapToLong(Duration::getSeconds)
                .sum();

        Duration totalTime = Duration.ofSeconds(totalLapTime);

        int hours = totalTime.toHoursPart();
        int minutes = totalTime.toMinutesPart();
        int seconds = totalTime.toSecondsPart();

        List<Integer> timeTaken = List.of(hours, minutes, seconds);
        DecimalFormat decimalFormat = new DecimalFormat("00");

        return timeTaken.stream()
                .map(decimalFormat::format)
                .collect(Collectors.joining(":"));
    }

    public void reset() {
        intervals.clear();
    }

    public void advanceTime(String timeString) {
        if (hasStartedTracking) {
            try {
                long[] time = Arrays.stream(timeString.split(":"))
                        .mapToLong(Long::parseLong)
                        .toArray();

                if (time.length != 3) {
                    throw new IllegalArgumentException();
                }

                Duration advanced = Duration.ofHours(time[0]).plusMinutes(time[1]).plusSeconds(time[2]);

                intervals.add(advanced);
                totalIntervals.add(advanced);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Time String must be numeric with the format 'HH:mm:ss'");
            }
        }
    }

}
