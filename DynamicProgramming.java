import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Double, Integer> coinChange(double[] coins, double amount) {
        int[] dp = new int[(int) (amount * 100) + 1];
        Arrays.fill(dp, (int) (amount * 100) + 1);
        dp[0] = 0;

        Map<Double, Integer>[] coinCounts = new HashMap[(int) (amount * 100) + 1];
        coinCounts[0] = new HashMap<>();
        coinCounts[0].put(0.0, 0);

        for (int i = 1; i <= (int) (amount * 100); i++) {
            coinCounts[i] = new HashMap<>();
            for (double coin : coins) {
                if ((int) (coin * 100) <= i && dp[i - (int) (coin * 100)] + 1 < dp[i]) {
                    dp[i] = dp[i - (int) (coin * 100)] + 1;

                    coinCounts[i].clear();
                    coinCounts[i].putAll(coinCounts[i - (int) (coin * 100)]);
                    coinCounts[i].merge(coin, 1, Integer::sum);
                }
            }
        }

        Map<Double, Integer> result = coinCounts[(int) (amount * 100)];
        System.out.println("Quantidade de cada moeda usada:");
        for (Map.Entry<Double, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + " moedas");
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
          double[] coins = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00}; // Exemplo de valores de moedas
        double amount = 1.00; // Valor para encontrar a quantidade de moedas usadas

        solution.coinChange(coins, amount); // Chama o método para calcular e imprimir o resultado
    }
}
