public class DecoratorPatternExample {

    // Step 1 & 2: Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 3: Concrete Component
    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending EMAIL notification: " + message);
        }
    }

    // Step 4: Abstract Decorator Class
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message); // Delegate to base notifier
        }
    }

    // Step 4: Concrete Decorator - SMS
    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS notification: " + message);
        }
    }

    // Step 4: Concrete Decorator - Slack
    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SLACK notification: " + message);
        }
    }

    // Step 5: Test Class
    public static void main(String[] args) {
        // Basic email notification
        Notifier basicEmail = new EmailNotifier();

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(basicEmail);

        // Email + SMS + Slack
        Notifier allChannels = new SlackNotifierDecorator(emailAndSMS);

        // Send a message
        System.out.println("Sending Notification:");
        allChannels.send("System maintenance scheduled at 10 PM tonight.");
    }
}
