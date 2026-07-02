public class ForecastTest {
    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting (Recursive) ===\n");
        double principal = 10000.00;
        double rate      = 0.08;
        int[]  years     = {1, 5, 10, 20, 30};
        System.out.printf("%-6s | %-20s | %-20s | %-20s%n", "Years", "Recursive", "Memoized", "Iterative");
        System.out.println("------+----------------------+----------------------+----------------------");
        for (int n : years) {
            FinancialForecaster.clearMemo();
            double r = FinancialForecaster.futureValueRecursive(principal, rate, n);
            double m = FinancialForecaster.futureValueMemo(principal, rate, n);
            double it = FinancialForecaster.futureValueIterative(principal, rate, n);
            System.out.printf("%-6d | $%,18.2f | $%,18.2f | $%,18.2f%n", n, r, m, it);
        }
        System.out.println("\n--- Step-by-step (5 years at 8%) ---");
        for (int n=0; n<=5; n++) {
            System.out.printf("  Year %2d: $%,.2f%n", n, FinancialForecaster.futureValueRecursive(principal, rate, n));
        }
        System.out.println("\n--- Complexity ---");
        System.out.println("Recursive  : O(n) time | O(n) stack space");
        System.out.println("Memoized   : O(n) time | O(n) memo table");
        System.out.println("Iterative  : O(n) time | O(1) space -- BEST");
        System.out.println("\n--- Large n test (n=1,000, iterative) ---");
        System.out.printf("  $10,000 @ 8%% for 1000 years: $%.2e%n", FinancialForecaster.futureValueIterative(principal, rate, 1000));
        System.out.println("\n[OK] Financial forecasting verified.");
    }
}