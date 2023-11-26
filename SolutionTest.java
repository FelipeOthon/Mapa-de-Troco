import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCoinChangeFor93_75() {
        Solution solution = new Solution();
        double[] coins = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
        double amount = 93.75;

        int[][] result = solution.coinChange(coins, amount);

        int[] expectedCounts = {0, 0, 1, 1, 1, 1, 0, 0, 2, 1, 0}; // Quantidade esperada para cada moeda

        assertArrayEquals(expectedCounts, result[(int) (amount * 100)], "Verificar a contagem de moedas para 93.75");
    }

    @Test
    void testCoinChangeFor80() {
        Solution solution = new Solution();
        double[] coins = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
        double amount = 80.00;

        int[][] result = solution.coinChange(coins, amount);

        int[] expectedCounts = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}; // Quantidade esperada para cada moeda

        assertArrayEquals(expectedCounts, result[(int) (amount * 100)], "Verificar a contagem de moedas para 80.00");
    }
}
