class GetWays {

    static long getNumberOfWays(long N, long[] Coins) {
        long[] ways = new long[(int) N + 1];
        long[][] usedCoins = new long[(int) N + 1][Coins.length]; // To store the coins used

        ways[0] = 1;

        for (int i = 0; i < Coins.length; i++) {
            for (int j = (int) Coins[i]; j <= N; j++) {
                ways[j] += ways[(int) (j - Coins[i])];

                // Copy the used coins for this value from the previous value
                System.arraycopy(usedCoins[(int) (j - Coins[i])], 0, usedCoins[j], 0, Coins.length);

                // Increment the used coin for the current denomination
                usedCoins[j][i] += 1;
            }
        }

        // Printing the coins used for minimum number of coins
        long[] minUsedCoins = usedCoins[(int) N];
        for (int i = 0; i < Coins.length; i++) {
            if (minUsedCoins[i] > 0) {
                System.out.println("Coin " + Coins[i] + " used " + minUsedCoins[i] + " times.");
            }
        }

        return ways[(int) N];
    }

    public static void main(String args[]) {
        long Coins[] = {2, 5, 10, 20, 50, 100};

        System.out.println("The Coins Array:");
        printArray(Coins);

        System.out.println("Solution:");
        System.out.println(getNumberOfWays(77, Coins));
    }

    static void printArray(long[] coins) {
        for (long i : coins)
            System.out.println(i);
    }
}