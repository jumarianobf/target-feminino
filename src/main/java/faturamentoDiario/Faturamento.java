package faturamentoDiario;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("I:\\FIAP\\Java\\target-feminino\\src\\main\\java\\faturamentoDiario\\faturamento.json"));
            JSONObject json = new JSONObject(tokener);
            JSONArray faturamentoDiarioArray = json.getJSONArray("faturamento_diario");

            List<Double> faturamentos = new ArrayList<>();
            double totalFaturamento = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoDiarioArray.length(); i++) {
                JSONObject node = faturamentoDiarioArray.getJSONObject(i);
                double valor = node.getDouble("valor");
                if (valor > 0) {
                    faturamentos.add(valor);
                    totalFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = totalFaturamento / diasComFaturamento;

            double menorValor = faturamentos.stream().min(Double::compareTo).orElse(0.0);
            double maiorValor = faturamentos.stream().max(Double::compareTo).orElse(0.0);

            long diasAcimaDaMedia = faturamentos.stream().filter(valor -> valor > mediaMensal).count();

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

