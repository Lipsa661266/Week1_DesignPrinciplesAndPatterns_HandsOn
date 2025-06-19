// Step 2: Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Concrete Strategy - Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card (Card Holder: " + cardHolderName + ")");
    }
}

// Step 3: Concrete Strategy - PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal (Email: " + email + ")");
    }
}

// Step 4: Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void payAmount(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// Step 5: Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        System.out.println("Using Credit Card:");
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Parbati Mohanty"));
        context.payAmount(1500.00);

        System.out.println();

        // Pay using PayPal
        System.out.println("Using PayPal:");
        context.setPaymentStrategy(new PayPalPayment("parbati@example.com"));
        context.payAmount(2500.00);
    }
}
