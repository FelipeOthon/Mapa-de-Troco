import java.util.Arrays;

class Solution {
    public int[][] coinChange(double[] coins, double amount) {
        int[] dp = new int[(int) (amount * 100) + 1];
        Arrays.fill(dp, (int) (amount * 100) + 1);
        dp[0] = 0;

        int[][] coinCounts = new int[(int) (amount * 100) + 1][coins.length];
        coinCounts[0][0] = 0;

        for (int i = 1; i <= (int) (amount * 100); i++) {
            int minCoins = Integer.MAX_VALUE;
            int coinIndex = -1;
            for (int j = 0; j < coins.length; j++) {
                if ((int) (coins[j] * 100) <= i && dp[i - (int) (coins[j] * 100)] + 1 < minCoins) {
                    minCoins = dp[i - (int) (coins[j] * 100)] + 1;
                    coinIndex = j;
                }
            }
            if (coinIndex != -1) {
                dp[i] = minCoins;
                System.arraycopy(coinCounts[i - (int) (coins[coinIndex] * 100)], 0, coinCounts[i], 0, coins.length);
                coinCounts[i][coinIndex]++;
            }
        }

        System.out.println("Quantidade de cada moeda usada:");
        for (int i = 0; i < coins.length; i++) {
            int count = coinCounts[(int) (amount * 100)][i];
            if (count > 0) {
                System.out.println(coins[i] + " = " + count + " moedas");
            }
        }

        return coinCounts;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] coins = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00}; // Exemplo de valores de moedas
        double amount = 93.75; // Valor para encontrar a quantidade de moedas usadas


        solution.coinChange(coins, amount); // Chama o método para calcular e imprimir o resultado
    }
}
