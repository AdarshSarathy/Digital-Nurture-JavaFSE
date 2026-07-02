import java.util.HashMap;
import java.util.Map;
public class FinancialForecaster {
    private static Map<Integer, Double> memo = new HashMap<Integer, Double>();
    public static double futureValueRecursive(double principal, double rate, int years) {
        if (years == 0) return principal;
        return futureValueRecursive(principal, rate, years-1) * (1+rate);
    }
    public static double futureValueMemo(double principal, double rate, int years) {
        if (years == 0) return principal;
        if (memo.containsKey(years)) return memo.get(years);
        double result = futureValueMemo(principal, rate, years-1) * (1+rate);
        memo.put(years, result);
        return result;
    }
    public static void clearMemo() { memo.clear(); }
    public static double futureValueIterative(double principal, double rate, int years) {
        double v = principal;
        for (int i=0; i<years; i++) v *= (1+rate);
        return v;
    }
}