public class CoinChangeGreedy {

    public static void main(String[] args) {
        double[] denominacoes = {0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
        double valor = 3527.45; // Valor em reais e centavos

        int[] troco = encontrarMinimo(denominacoes, valor);

        System.out.println("Moedas utilizadas para dar troco de " + valor + ":");
        imprimirTroco(troco, denominacoes);
    }

    // Abordagem gananciosa para encontrar a quantidade mínima de moedas
    public static int[] encontrarMinimo(double[] denominacoes, double valor) {
        int[] resultado = new int[denominacoes.length];
        int indice = denominacoes.length - 1;

        while (indice >= 0 && valor > 0) {
            if (denominacoes[indice] <= valor) {
                resultado[indice]++;
                valor -= denominacoes[indice];
                valor = Math.round(valor * 100.0) / 100.0; // Arredonda para lidar com precisão de ponto flutuante
            } else {
                indice--;
            }
        }

        return resultado;
    }

    // Método auxiliar para imprimir as denominações utilizadas
    public static void imprimirTroco(int[] troco, double[] denominacoes) {
        String[] nomesMoedas = {"R$0.05", "R$0.10", "R$0.25", "R$0.50", "R$1", "R$2", "R$5", "R$10", "R$20", "R$50", "R$100"};

        for (int i = 0; i < troco.length; i++) {
            if (troco[i] > 0) {
                System.out.println(nomesMoedas[i] + ": " + troco[i] + " quantidade(s)");
            }
        }
    }
}
