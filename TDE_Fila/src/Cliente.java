public class Cliente {

    private String nome;
    private int tempo;

    public Cliente(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public int getTempo() {
        return tempo;
    }
}
