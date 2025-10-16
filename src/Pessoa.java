import java.util.ArrayList;

public abstract class Pessoa {
    static private int countPessoa = 0;

    private int id;
    private String nome;
    private String cpf;
    private String endereco;

    public static int getCountPessoa() {
        return countPessoa;
    }

    public static void setCountPessoa(int countPessoa) {
        Pessoa.countPessoa = countPessoa;
    }

    abstract void atualizarDados();
}
