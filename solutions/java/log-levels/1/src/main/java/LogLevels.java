public class LogLevels {
    
    public static String message(String logLine) {
        String[] parts = logLine.split(":");
        return parts[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] parts = logLine.split(":");
        String level = parts[0].replace("[", "");
        level = level.replace("]", "");
        return level.toLowerCase();
    }

    public static String reformat(String logLine) {
        String logMessage = message(logLine);
        String level = logLevel(logLine);
        StringBuilder str = new StringBuilder(level);
        str.insert(0, " (");
        str.append(")");
        return logMessage.concat(str.toString());
    }
}
