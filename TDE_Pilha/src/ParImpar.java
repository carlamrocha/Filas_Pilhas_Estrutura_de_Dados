import java.util.Scanner;
import java.util.Stack;

public class ParImpar {

    private Stack <Integer> par;
    private Stack <Integer> impar;
    private Scanner sc;

    public ParImpar() {
        par = new Stack<>();
        impar = new Stack<>();
        sc = new Scanner(System.in);
    }

    public void iniciar() {

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite um número: ");
            int numero = sc.nextInt();

            if (numero == 0) {

                if (par.isEmpty() || impar.isEmpty()) {

                    System.out.println("Erro: uma das pilhas está vazia.");

                } else {

                    System.out.println("Desempilhando par: " + par.pop());
                    System.out.println("Desempilhando impar: " + impar.pop());
                }

            } else if (numero % 2 == 0) {

                par.push(numero);

            } else {

                impar.push(numero);
            }
        }

        System.out.println("\n--- PILHA PAR ---");

        while (!par.isEmpty()) {
            System.out.println(par.pop());
        }

        System.out.println("\n--- PILHA ÍMPAR ---");

        while (!impar.isEmpty()) {
            System.out.println(impar.pop());
        }

        sc.close();
    }
}
