import java.util.ArrayList;

public class Clinica {
    private ArrayList<Cliente> clientes =  new ArrayList<>();
    private ArrayList<Funcionario> funcionarios =   new ArrayList<>();

    public void AdicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void AdicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public void MostrarClientesEFuncionarios() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
}
