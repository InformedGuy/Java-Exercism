import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long GIGASECONDS = (long) 1e9;

    private LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGASECONDS);
    }

    public LocalDateTime getDateTime() {
        return moment;
    }

}
