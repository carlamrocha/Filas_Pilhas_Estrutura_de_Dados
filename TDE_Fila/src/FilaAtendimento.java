import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaAtendimento {

    private Scanner sc;
    private Queue<Cliente> fila;

    public FilaAtendimento() {
        sc = new Scanner(System.in);
        fila = new LinkedList<>();
    }

    public void iniciar() {

        System.out.print("Digite a quantidade de clientes: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        // Inserindo os clientes na fila
        for (int i = 0; i < quantidade; i++) {

            System.out.print("Digite o nome do cliente: ");
            String nome = sc.nextLine();

            System.out.print("Digite o tempo de atendimento (minutos): ");
            int tempo = sc.nextInt();
            sc.nextLine();

            Cliente cliente = new Cliente(nome, tempo);

            fila.add(cliente);
        }

        int totalTempo = 0;
        int totalClientes = 0;

        System.out.println("\n--- ATENDIMENTO ---");

        // Atendendo os clientes
        while (!fila.isEmpty()) {

            Cliente cliente = fila.poll();

            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Tempo: " + cliente.getTempo() + " minutos");

            totalTempo += cliente.getTempo();
            totalClientes++;
        }

        System.out.println("\n--- RESUMO ---");
        System.out.println("Total de clientes atendidos: " + totalClientes);
        System.out.println("Total de tempo gasto: " + totalTempo + " minutos");
        sc.close();
    }
}
