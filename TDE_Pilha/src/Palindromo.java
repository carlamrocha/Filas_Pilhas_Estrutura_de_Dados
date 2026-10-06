import java.util.Scanner;
import java.util.Stack;
public class Palindromo {

    private Scanner sc;
    private Stack<Character> pilha;

    public Palindromo() {
        sc = new Scanner(System.in);
        pilha = new Stack<>();
    }

    public void iniciar() {

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(palavra.charAt(i));
        }
        boolean palindromo = true;

        // Compara a palavra com a pilha
        for (int i = 0; i < palavra.length(); i++) {
            char letra = pilha.pop();
            if (letra != palavra.charAt(i)) {
                palindromo = false;
                break;
            }
        }

        if (palindromo) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo!");
        }
        sc.close();
    }
}
