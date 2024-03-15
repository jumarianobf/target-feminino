package faturamentoMensal;

import java.util.HashMap;
import java.util.Map;

public class faturamentoMensal {
    public static void main(String[] args) {
        Map<String, Double> faturamentos = new HashMap<>();
        faturamentos.put("SP", 67836.43);
        faturamentos.put("RJ", 36678.66);
        faturamentos.put("MG", 29229.88);
        faturamentos.put("ES", 27165.48);
        faturamentos.put("Outros", 19849.53);

        double total = faturamentos.values().stream().mapToDouble(Double::doubleValue).sum();

        for (Map.Entry<String, Double> entry : faturamentos.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / total) * 100;
            System.out.printf("Percentual de representação de %s: %.2f%%\n", estado, percentual);
        }
    }
}
