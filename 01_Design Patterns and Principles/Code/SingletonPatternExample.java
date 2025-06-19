public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {
        private static Logger instance;

        // Private constructor to prevent external instantiation
        private Logger() {
            System.out.println("Logger instance created.");
        }

        // Public method to return the singleton instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Example method to log messages
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message.");

        // Verifying singleton behavior
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different logger instances!");
        }
    }
}
