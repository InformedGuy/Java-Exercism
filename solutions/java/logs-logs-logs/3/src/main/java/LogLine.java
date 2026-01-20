public class LogLine {

    String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String log = logLine.substring(1, 4);

        return switch (log) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };

    }

    public String getOutputForShortLog() {
        String logMessage = logLine.substring(7);
        LogLevel level = getLogLevel();

        return level.getLogNumber() + ":" + logMessage;
    }
}
