package model;

import exception.AnimalInexistenteException;
import exception.ClienteInexistenteException;
import java.util.ArrayList;

public class Clinica {

    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();
    private ArrayList<Funcionario> funcionariosDaClinica = new ArrayList<>();
    private ArrayList<Cliente> clientesDaClinica = new ArrayList<>();
    private ArrayList<Consulta> consultasDaClinica = new ArrayList<>();

    // talvez aqui fosse melhor um map para mostrar cada cliente associado a um produto/serviço
    private ArrayList<Produto> produtosDoCliente_Cons= new ArrayList<>();
    private ArrayList<Servico> servicosDoCliente_Cons= new ArrayList<>();

    public Clinica() {
    }

    // create Veterinário
    public void adicionarVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.add(veterinario);
        System.out.println("Veterinário adicionado com sucesso!");
    }

    // remove Veterinário
    public void removerVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.remove(veterinario);
        System.out.println("Veterinário removido com sucesso!");
    }

    // update Veterinário
    public void atualizarVeterinário(String nome, String endereco, String telefone, float salario, String CRMV) {
        for (Veterinario veterinarioIndividual : veterinariosDaClinica) {
            if (veterinarioIndividual.getCRMV().equals(CRMV)) {
                veterinarioIndividual.atualizarDados(nome, endereco, telefone, salario, CRMV);
            }
        }
        System.out.println("Veterinário atualizado com sucesso!");
    }

    // read Veterinario
    public void lerVeterinário(String CRMV) {
        for (Veterinario veterinario : veterinariosDaClinica) {
            if (veterinario.getCRMV().equals(CRMV)) {
                veterinario.exibirDados();
            }
        }
    }

    // create funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionariosDaClinica.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    // remove funcionário
    public void removerFuncionario(Funcionario funcionario) {
        funcionariosDaClinica.remove(funcionario);
        System.out.println("Funcionário removido com sucesso!");
    }

    // update funcionario
    public void atualizarFuncionario(String nome, String endereco, String telefone, float salario,
            String identificadorCarteiraTrabalho, Cargo cargo) {
        for (Funcionario funcionarioIndividual : funcionariosDaClinica) {
            if (funcionarioIndividual.getIdentificadorCarteiraTrabalho().equals(identificadorCarteiraTrabalho)) {
                funcionarioIndividual.atualizarDados(nome, endereco, telefone, salario, identificadorCarteiraTrabalho,
                        cargo);
            }
        }
        System.out.println("Funcionário atualizado com sucesso!");
    }

    // listar funcionario
    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionariosDaClinica) {
            funcionario.exibirDados();
        }
    }

    // get lista funcionarios
    public ArrayList<Funcionario> getFuncionariosDaClinica() {
        return funcionariosDaClinica;
    }

    // create cliente
    public void adicionarCliente(Cliente cliente) {
        clientesDaClinica.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    // listar clientes
    public void listarClientes() {
        System.out.println("Lista de Clientes da Clínica:");
        for (Cliente cliente : clientesDaClinica) {
            cliente.exibirDados();
        }
    }

    // get cliente
    public Cliente getCliente(String cpf) {
        Cliente clienteEncontrado = clientesDaClinica.stream().filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst().orElse(null);

        if (clienteEncontrado != null) {
            return clienteEncontrado;

        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");

        }
    }

    // update cliente
    public void atualizarCliente(Cliente cliente, String nome, String endereco, String telefone) {
        Cliente clienteClinica = clientesDaClinica.stream()
                .filter(clienteAntigo -> clienteAntigo.getCpf().equals(cliente.getCpf())).findFirst().orElse(null);

        if (clienteClinica != null) {
            clienteClinica.atualizarDados(nome, endereco, telefone);

        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");

        }
    }

    // remove cliente
    public void removerCliente(Cliente cliente) {
        clientesDaClinica.remove(cliente);
    }

    // get lista de clientes
    public ArrayList<Cliente> getClientesDaClinica() {
        return this.clientesDaClinica;
    }

    // update animal do cliente
    public void atualizarAnimal(Animal animal, String nome, Especie especie, String raca, java.util.Date dataNascimento) {
        if( animal == null ) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }

        animal.atualizarDados(nome, especie, raca, dataNascimento);
    }

    // remover animal do cliente
    public void removerAnimal(Animal animal, Cliente cliente) {
        if( animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }
        if (cliente == null ) {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
        cliente.removerAnimal(animal.getId());
    }

    // adicionar animal ao cliente
    public void adicionarAnimal(Animal animal, Cliente cliente) {
        if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }
        if  (cliente == null) {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }

        cliente.adicionarAnimal(animal);
    }

    public void listarAnimaisDoCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }

        cliente.mostrarListaDeAnimais();

    }


    public void adicionarConsulta(Consulta consulta) {
    consultasDaClinica.add(consulta);
    System.out.println("Consulta agendada com sucesso!");
}

// READ - Listar consultas
    public void listarConsultas() {
        System.out.println("Lista de Consultas:");
        for (Consulta consulta : consultasDaClinica) {
            System.out.println("ID: " + consulta.getId() + 
                            " | Data: " + consulta.getData() +
                            " | Hora: " + consulta.getHora() +
                            " | Status: " + consulta.getStatus());
        }
    }

    // DELETE - Remover consulta
    public void removerConsulta(Consulta consulta) {
        consultasDaClinica.remove(consulta);
        System.out.println("Consulta removida com sucesso!");
    }

    // GET - Obter lista de consultas
    public ArrayList<Consulta> getConsultasDaClinica() {
        return consultasDaClinica;
    }

        // CREATE - Cria o serviço e adciona no Array
    public void AddServico(Servico serv){
        servicosDoCliente_Cons.add(serv);
        System.out.println("Serviço adicionado: "+serv.getNome());
    }

    // REMOVE - Remove o serviço 
    public void RemvServico(Servico serv){
        servicosDoCliente_Cons.remove(serv);
        System.out.println("Serviço removido: "+serv.getNome());
    }

    // READ - leitura do nome do serviço
    public void lerServico(String sv){
        for(Servico s: servicosDoCliente_Cons){
            if(s.getNome().equals(sv)){
                s.imprimirDados();
            }
        }
    }

    // UPDATE - atualiza o serviço
    public void atualizaServ(int id,String nome, String desc, float preco, Animal animal, 
    ArrayList<Funcionario> listaDeFuncionarios){
        for(Servico s: servicosDoCliente_Cons){
            if(s.getID()==id){
                s.atualizarDados(id, nome, desc, preco, animal, listaDeFuncionarios);
            }
        }

    }



}
