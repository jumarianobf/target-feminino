package inversaoString;

import java.util.Scanner;

public class Inversao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra para inverter: ");
        String entrada = scanner.nextLine();

        if (entrada != null) {
            String invertida = inverterString(entrada);
            System.out.println("String original: " + entrada);
            System.out.println("String invertida: " + invertida);
        } else {
            System.out.println("A entrada é nula.");
        }

        scanner.close();
    }
    public static String inverterString(String input) {
        char[] caracteres = input.toCharArray();
        int tamanho = caracteres.length;
        char[] invertidos = new char[tamanho];

        for (int i = 0; i < tamanho; i++) {
            invertidos[i] = caracteres[tamanho - i - 1];
        }

        return new String(invertidos);
    }
}
