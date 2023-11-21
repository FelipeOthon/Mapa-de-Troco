public class CoinChangeHeuristic {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 93;

        int[] change = getChange(coins, amount);

        System.out.println("Coins used to make change for " + amount + ":");
        for (int coin : change) {
            System.out.print(coin + " ");
        }
    }

    // Heuristic: Largest coin first
    public static int[] getChange(int[] coins, int amount) {
        int index = 0;
        int[] result = new int[coins.length];

        // Loop through the coins without sorting
        while (amount > 0 && index < coins.length) {
            if (coins[index] <= amount) {
                result[index]++;
                amount -= coins[index];
            } else {
                index++;
            }
        }

        return result;
    }
}