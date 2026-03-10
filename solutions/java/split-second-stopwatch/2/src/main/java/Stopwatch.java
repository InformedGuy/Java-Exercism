import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
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

    public void advanceTime(String[] time) {
        if (hasStartedTracking) {
            long hours = Long.parseLong(time[0]);
            long minutes = Long.parseLong(time[1]);
            long seconds = Long.parseLong(time[2]);

            Duration advanced = Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);

            intervals.add(advanced);
            totalIntervals.add(advanced);
        }
    }

}
