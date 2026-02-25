public class LogLine {

    String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String[] parts = logLine.split(": ");
        String log = parts[0].replaceAll("[\\[\\]]", "");

        switch (log) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        String[] parts = logLine.split(": ");
        String logMessage = parts[1];

        LogLevel level = getLogLevel();
        return level.getLogNumber() + ":" + logMessage;
    }
}
