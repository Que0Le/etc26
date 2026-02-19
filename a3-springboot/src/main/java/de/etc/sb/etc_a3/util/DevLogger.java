package de.etc.sb.etc_a3.util;

public class DevLogger {

    private static final String PREFIX_INFO = "[INFO]";
    private static final String PREFIX_ERROR = "[ERROR]";
    private static final String PREFIX_DEBUG = "[DEBUG]";

    private static String getLocation() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // stackTrace[0] = getStackTrace
        // stackTrace[1] = getLocation
        // stackTrace[2] = calling method
        if (stackTrace.length > 3) {
            StackTraceElement elem = stackTrace[3];
            return String.format("(%s:%d) %s()", elem.getFileName(), elem.getLineNumber(), elem.getMethodName());
        }
        return "(Unknown)";
    }

    private static String getLocationWithCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // stackTrace[0] = getStackTrace
        // stackTrace[1] = getLocation
        // stackTrace[2] = calling method
        if (stackTrace.length > 4) {
            StackTraceElement caller = stackTrace[4];
            StackTraceElement elem = stackTrace[3];
            return String.format("(%s:%d) -> (%s:%d) %s()",
                    caller.getFileName(), caller.getLineNumber(),
                    elem.getFileName(), elem.getLineNumber(),
                    elem.getMethodName());
        }
        return "(Unknown)";
    }

    public static void info(String message) {
        System.out.println(PREFIX_INFO + " " + getLocation() + " - " + message);
    }

    public static void debug(String message) {
        System.out.println(PREFIX_DEBUG + " " + getLocationWithCaller() + " - " + message);
    }

    public static void error(String message) {
        System.err.println(PREFIX_ERROR + " " + getLocation() + " - " + message);
    }

    public static void error(String message, Throwable t) {
        System.err.println(PREFIX_ERROR + " " + getLocation() + " - " + message);
        t.printStackTrace(System.err);
    }
}