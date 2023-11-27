import java.util.Arrays;

public class DynamicProgramming {
    public static int[] trocoDeMoedasDinamico(double[] moedas, double valorTroco) {
        int valorTrocoCentavos = (int) (valorTroco * 100); // Convertendo o valor do troco para centavos
        int[] moedasCentavos = new int[moedas.length]; // Convertendo as moedas para centavos
        for (int i = 0; i < moedas.length; i++) {
            moedasCentavos[i] = (int) (moedas[i] * 100);
        }

        int[] quantidadeMoedas = new int[valorTrocoCentavos + 1];
        quantidadeMoedas[0] = 0;

        int[][] usadas = new int[valorTrocoCentavos + 1][moedasCentavos.length];

        for (int i = 1; i <= valorTrocoCentavos; i++) {
            quantidadeMoedas[i] = Integer.MAX_VALUE;

            for (int j = 0; j < moedasCentavos.length; j++) {
                int moeda = moedasCentavos[j];
                if (moeda <= i) {
                    int subProblema = quantidadeMoedas[i - moeda] + 1;
                    if (subProblema < quantidadeMoedas[i]) {
                        quantidadeMoedas[i] = subProblema;
                        System.arraycopy(usadas[i - moeda], 0, usadas[i], 0, moedasCentavos.length);
                        usadas[i][j]++;
                    }
                }
            }
        }

        return usadas[valorTrocoCentavos];
    }

    public static void main(String[] args) {
        double[] moedas = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
        double valorTroco = 128.25;

        int[] quantidadeMoedasUsadas = trocoDeMoedasDinamico(moedas, valorTroco);

        for (int i = 0; i < quantidadeMoedasUsadas.length; i++) {
            if (quantidadeMoedasUsadas[i] > 0) {
                double valor = moedas[i];
                System.out.println(String.format("%.2f = %d", valor, quantidadeMoedasUsadas[i]));
            }
        }
    }
}
