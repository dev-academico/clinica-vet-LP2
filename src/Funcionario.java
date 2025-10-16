public class Funcionario extends Pessoa {
    private Float salario;
    private String cargo;

    public boolean registrarAtendimento() {
        return true;
    }

    public boolean gerenciarAgendamentos() {
        return true;
    }

    @Override
    void atualizarDados() {

    }
}
