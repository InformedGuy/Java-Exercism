import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long GIGA = (long) 1e9;

    private LocalDateTime currentTime;
    private LocalDateTime futureTime;

    // Find the date and time one gigasecond after a certain date

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.currentTime = moment;
        this.futureTime = getFutureTime();
    }

    public LocalDateTime getDateTime() {
        return futureTime;
    }

    private LocalDateTime getFutureTime() {
        return currentTime.plusSeconds(GIGA);
    }
}
