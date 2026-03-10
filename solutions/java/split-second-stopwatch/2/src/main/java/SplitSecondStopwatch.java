import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    private final Stopwatch stopwatch;
    private final List<String> previousLaps;

    private State state;

    public SplitSecondStopwatch() {
        stopwatch = new Stopwatch();
        previousLaps = new ArrayList<>();
        state = State.READY;
    }

    public void start() {
        if (state == State.RUNNING) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }

        stopwatch.start();
        state = State.RUNNING;
    }

    public void stop() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }

        stopwatch.stop();
        state = State.STOPPED;
    }

    public void reset() {
        if (state != State.STOPPED) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }

        previousLaps.clear();
        stopwatch.reset();

        state = State.READY;
    }

    public void lap() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }

        previousLaps.add(stopwatch.getLap());
        stopwatch.reset();
    }

    public String state() {
        return state.getState();
    }

    public String currentLap() {
        return stopwatch.getLap();
    }

    public String total() {
        return stopwatch.getTotal();
    }

    public List<String> previousLaps() {
        return previousLaps;
    }

    public void advanceTime(String timeString) {
        stopwatch.advanceTime(timeString.split(":"));
    }
}