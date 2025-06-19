public class AdapterPatternExample {

    // Step 1: Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 2: Adaptee Class - PayPal
    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("PayPal processed payment of ₹" + amount);
        }
    }

    // Step 2: Adaptee Class - Stripe
    static class StripeGateway {
        public void makePayment(double amountInRupees) {
            System.out.println("Stripe processed payment of ₹" + amountInRupees);
        }
    }

    // Step 2: Adaptee Class - Razorpay
    static class RazorpayGateway {
        public void doTransaction(double amt) {
            System.out.println("Razorpay processed payment of ₹" + amt);
        }
    }

    // Step 3: Adapter for PayPal
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;

        public PayPalAdapter() {
            this.payPalGateway = new PayPalGateway();
        }

        public void processPayment(double amount) {
            payPalGateway.sendPayment(amount);
        }
    }

    // Step 3: Adapter for Stripe
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter() {
            this.stripeGateway = new StripeGateway();
        }

        public void processPayment(double amount) {
            stripeGateway.makePayment(amount);
        }
    }

    // Step 3: Adapter for Razorpay
    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpayGateway;

        public RazorpayAdapter() {
            this.razorpayGateway = new RazorpayGateway();
        }

        public void processPayment(double amount) {
            razorpayGateway.doTransaction(amount);
        }
    }

    // Step 4: Test class
    public static void main(String[] args) {
        // Using PayPal through adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment(2500.00);

        // Using Stripe through adapter
        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment(1500.00);

        // Using Razorpay through adapter
        PaymentProcessor razorpayProcessor = new RazorpayAdapter();
        razorpayProcessor.processPayment(3000.00);
    }
}
