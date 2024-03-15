package fibonacci;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número para verificar se pertence à sequência de Fibonacci: ");
            int numero = scanner.nextInt();

            boolean pertence = verificaFibonacci(numero);

            if (pertence) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    public static boolean verificaFibonacci(int numero) {
        int anterior = 0;
        int atual = 1;

        for (int i = 0; atual <= numero; i++) {
            if (atual == numero) {
                return true;
            }
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return false;
    }
}

