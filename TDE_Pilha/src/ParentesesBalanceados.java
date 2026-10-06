import java.util.Scanner;
import java.util.Stack;

public class ParentesesBalanceados {

    private Scanner sc;
    private Stack<Character> pilha;

    public ParentesesBalanceados() {
        sc = new Scanner(System.in);
        pilha = new Stack<>();
    }

    public void iniciar() {

        System.out.print("Digite uma expressão matemática: ");
        String expressao = sc.nextLine();

        boolean balanceado = true;

        for (int i = 0; i < expressao.length(); i++) {

            char caractere = expressao.charAt(i);

            // Se for abertura, empilha
            if (caractere == '(' || caractere == '[' || caractere == '{') {

                pilha.push(caractere);
            }

            // Se for fechamento
            else if (caractere == ')' || caractere == ']' || caractere == '}') {

                // Não pode fechar se a pilha estiver vazia
                if (pilha.isEmpty()) {

                    balanceado = false;
                    break;
                }

                char topo = pilha.pop();

                // Verifica se os pares correspondem
                if (caractere == ')' && topo != '(') {
                    balanceado = false;
                    break;
                }

                if (caractere == ']' && topo != '[') {
                    balanceado = false;
                    break;
                }

                if (caractere == '}' && topo != '{') {
                    balanceado = false;
                    break;
                }
            }
        }

        // Se ainda houver algo na pilha, faltou fechar
        if (!pilha.isEmpty()) {
            balanceado = false;
        }

        if (balanceado) {
            System.out.println("Balanceado");
        } else {
            System.out.println("Não balanceado");
        }

        sc.close();
    }
}
