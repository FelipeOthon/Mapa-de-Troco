public class CoinChangeGreedy {

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 93;

        int[] change = findMin(denominations, amount);

        System.out.println("Denominations used to make change for " + amount + ":");
        printChange(change, denominations);
    }

    // Greedy approach to find minimum denominations
    public static int[] findMin(int[] denominations, int amount) {
        int[] result = new int[denominations.length];
        int index = denominations.length - 1;

        while (index >= 0 && amount > 0) {
            if (denominations[index] <= amount) {
                result[index]++;
                amount -= denominations[index];
            } else {
                index--;
            }
        }

        return result;
    }

    // Helper method to print the denominations used
    public static void printChange(int[] change, int[] denominations) {
        for (int i = 0; i < change.length; i++) {
            for (int j = 0; j < change[i]; j++) {
                System.out.print(denominations[i] + " ");
            }
        }
    }
}