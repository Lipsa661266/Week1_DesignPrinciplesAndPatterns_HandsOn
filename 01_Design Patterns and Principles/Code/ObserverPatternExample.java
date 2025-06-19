import java.util.*;

// Step 2: Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Step 4: Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(stockName, stockPrice);
        }
    }

    // Custom method to change stock price
    public void setStockPrice(String stockName, double newPrice) {
        this.stockName = stockName;
        this.stockPrice = newPrice;
        System.out.println("\n[Stock Update] " + stockName + " price changed to ₹" + newPrice);
        notifyObservers();
    }
}

// Step 5: Concrete Observer - Mobile App
class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("📱 MobileApp - " + user + " notified: " + stockName + " is now ₹" + price);
    }
}

// Step 5: Concrete Observer - Web App
class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("💻 WebApp - " + user + " notified: " + stockName + " is now ₹" + price);
    }
}

// Step 6: Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create stock market subject
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileObserver = new MobileApp("Alice");
        Observer webObserver = new WebApp("Bob");

        // Register observers
        stockMarket.registerObserver(mobileObserver);
        stockMarket.registerObserver(webObserver);

        // Simulate stock price changes
        stockMarket.setStockPrice("TATA MOTORS", 820.50);
        stockMarket.setStockPrice("INFY", 1412.75);

        // Deregister one observer and test again
        stockMarket.removeObserver(webObserver);
        stockMarket.setStockPrice("RELIANCE", 2680.00);
    }
}
