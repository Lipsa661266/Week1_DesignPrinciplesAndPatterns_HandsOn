import java.util.HashMap;
import java.util.Scanner;

public class FinancialForecasting {

    // Basic recursive function to forecast future value
    public static double forecastRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecastRecursive(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized recursive function using memoization
    static HashMap<Integer, Double> memo = new HashMap<>();
    public static double forecastMemo(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = forecastMemo(currentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.print("Enter current value (₹): ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (in %, e.g., 5 for 5%): ");
        double growthRate = sc.nextDouble() / 100;

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        // Without memoization
        double resultRecursive = forecastRecursive(currentValue, growthRate, years);
        System.out.printf("Forecasted value (Recursive): ₹%.2f\n", resultRecursive);

        // With memoization
        double resultMemo = forecastMemo(currentValue, growthRate, years);
        System.out.printf("Forecasted value (Memoized): ₹%.2f\n", resultMemo);

        sc.close();
    }
}
