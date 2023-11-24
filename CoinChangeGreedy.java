public class CoinChangeGreedy {

    public static void main(String[] args) {
        double[] denominations = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
        double amount = 3527.45; // Montante em reais e centavos

        int[] change = findMin(denominations, amount);

        System.out.println("Denominations used to make change for " + amount + ":");
        printChange(change, denominations);
    }

    // Greedy approach to find minimum denominations
    public static int[] findMin(double[] denominations, double amount) {
        int[] result = new int[denominations.length];
        int index = denominations.length - 1;

        while (index >= 0 && amount > 0) {
            if (denominations[index] <= amount) {
                result[index]++;
                amount -= denominations[index];
                amount = Math.round(amount * 100.0) / 100.0; // Arredonda para lidar com precisão de ponto flutuante
            } else {
                index--;
            }
        }

        return result;
    }

    // Helper method to print the denominations used
    public static void printChange(int[] change, double[] denominations) {
        String[] currencyNames = {"R$0.05", "R$0.10", "R$0.25", "R$0.50", "R$1", "R$2", "R$5", "R$10", "R$20", "R$50", "R$100"};

        for (int i = 0; i < change.length; i++) {
            if (change[i] > 0) {
                System.out.println(currencyNames[i] + ": " + change[i] + " quantidades");
            }
        }
    }
}
