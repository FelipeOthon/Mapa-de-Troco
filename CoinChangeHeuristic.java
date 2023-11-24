public class CoinChangeHeuristic {

    public static void main(String[] args) {
        double[] denominations = {100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.25, 0.10, 0.05};
        double amount = 193.00;

        int[] change = getChange(denominations, amount);

        System.out.println("Denominations used to make change for " + amount + ":");
        for (int i = 0; i < change.length; i++) {
            if (change[i] > 0) {
                System.out.println(denominations[i] + ": " + change[i] + " notes");
            }
        }
    }

    // Heuristic: Largest coin first
    public static int[] getChange(double[] denominations, double amount) {
        int index = 0;
        int[] result = new int[denominations.length];

        // Loop through the denominations without sorting
        while (amount > 0 && index < denominations.length) {
            if (denominations[index] <= amount) {
                result[index]++;
                amount -= denominations[index];
                amount = Math.round(amount * 100.0) / 100.0; // Arredonda para lidar com precisão de ponto flutuante
            } else {
                index++;
            }
        }

        return result;
    }
}
