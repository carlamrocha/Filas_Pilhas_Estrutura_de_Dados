import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaImpressao {

    private Scanner sc;
    private Queue<Documento> fila;

    public FilaImpressao() {
        sc = new Scanner(System.in);
        fila = new LinkedList<>();
    }

    public void iniciar() {

        System.out.print("Digite a quantidade de documentos: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        // Inserindo documentos na fila
        for (int i = 0; i < quantidade; i++) {

            System.out.print("Digite o nome do documento: ");
            String nome = sc.nextLine();

            System.out.print("Digite o número de páginas: ");
            int paginas = sc.nextInt();
            sc.nextLine();

            Documento documento = new Documento(nome, paginas);

            fila.add(documento);
        }

        int totalPaginas = 0;
        int contador = 0;

        Documento maiorDocumento = null;
        System.out.println("\n--- IMPRESSÃO ---");

        // Imprimindo os documentos
        while (!fila.isEmpty()) {

            Documento documento = fila.poll();
            System.out.println("\nImprimindo: " + documento.getNome());
            System.out.println("Páginas: " + documento.getPaginas());

            totalPaginas += documento.getPaginas();
            contador++;

            // Verifica o documento com maior número de páginas
            if (maiorDocumento == null ||
                    documento.getPaginas() > maiorDocumento.getPaginas()) {

                maiorDocumento = documento;
            }

            // A cada duas impressões, mostra o próximo documento
            if (contador % 2 == 0 && !fila.isEmpty()) {

                Documento proximo = fila.peek();

                System.out.println("\nPróximo documento:");
                System.out.println("Nome: " + proximo.getNome());
                System.out.println("Páginas: " + proximo.getPaginas());
            }
        }

        System.out.println("\n--- RESUMO ---");

        System.out.println("Documento com maior número de páginas:");
        System.out.println("Nome: " + maiorDocumento.getNome());
        System.out.println("Páginas: " + maiorDocumento.getPaginas());

        System.out.println("\nTotal de páginas impressas: " + totalPaginas);

        sc.close();
    }
}
