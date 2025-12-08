package model;

import exception.AnimalInexistenteException;
import exception.ClienteInexistenteException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Clinica {

    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();
    private ArrayList<Funcionario> funcionariosDaClinica = new ArrayList<>();
    private ArrayList<Cliente> clientesDaClinica = new ArrayList<>();
    private ArrayList<Consulta> consultasDaClinica = new ArrayList<>();
    private ArrayList<Servico>  servicosDaClinica = new ArrayList<>();
    private ArrayList<PlanoPet> planosDaClinica  = new ArrayList<>();

    // talvez aqui fosse melhor um map para mostrar cada cliente associado a um produto/serviço
    private ArrayList<Produto> produtosDaClinica = new ArrayList<>();

    public Clinica() {
    }

    public void adicionarVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.add(veterinario);
        veterinario.enviarNotificacao("Veterinário adicionado com sucesso!");
    }

    public void removerVeterinário(Veterinario veterinario) {
        if(veterinariosDaClinica.contains(veterinario)) {
            veterinariosDaClinica.remove(veterinario);
            veterinario.enviarNotificacao("Veterinário removido com sucesso!");
        } else {
            throw new InvalidParameterException("Veterinário não encontrado!");
        }
    }

    public void atualizarVeterinário(Veterinario veterinario, String nome, String endereco, String telefone, float salario) {
        if (veterinariosDaClinica.contains(veterinario)) {
            veterinario.atualizarDados(nome, endereco, telefone, salario);
            veterinario.enviarNotificacao("Veterinário atualizado com sucesso!");
        } else {
            throw new InvalidParameterException("Veterinário não encontrado!");
        }
    }

    public void listarVeterinarios() {
        System.out.println("Veterinários da clínica");
        for (Veterinario veterinario : veterinariosDaClinica) {
            veterinario.exibirDados(true);
        }
    }

    public ArrayList<Veterinario> getTotalVeterinariosDaClinica() {
        return this.veterinariosDaClinica;
    }

    public ArrayList<Veterinario> getParteVeterinariosDaClinica(int[] numeros) {
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        for (int numero : numeros) {
            veterinarios.add(veterinariosDaClinica.get(numero - 1));
        }
        return veterinarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionariosDaClinica.add(funcionario);
        funcionario.enviarNotificacao("Funcionário adicionado com sucesso!");
    }

    public void removerFuncionario(Funcionario funcionario) {
        if (funcionariosDaClinica.contains(funcionario)) {
            funcionariosDaClinica.remove(funcionario);
            funcionario.enviarNotificacao("Funcionario removido com sucesso!");
        } else {
            throw new InvalidParameterException("Funcionário não encontrado!");
        }
    }

    public void atualizarFuncionario(Funcionario funcionario, String nome, String endereco, String telefone, float salario, Cargo cargo) {
        if (funcionariosDaClinica.contains(funcionario)) {
            funcionario.atualizarDados(nome, endereco, telefone, salario, cargo);
        } else {
            throw new InvalidParameterException("Funcionário não encontrado!");
        }
    }

    public void listarFuncionarios() {
        System.out.println("Funcionários da clínica:");
        for (Funcionario funcionario : funcionariosDaClinica) {
            funcionario.exibirDados(true);
        }
    }

    public ArrayList<Funcionario> getFuncionariosDaClinica() {
        return funcionariosDaClinica;
    }

    public void adicionarCliente(Cliente cliente) {
        clientesDaClinica.add(cliente);
        cliente.enviarNotificacao("Cliente adicionado com sucesso!");
    }

    public void listarClientes() {
        System.out.println("Clientes da clínica:");
        for (Cliente cliente : clientesDaClinica) {
            cliente.exibirDados(true);
        }
    }

    public void atualizarCliente(Cliente cliente, String nome, String endereco, String telefone) {

        if (clientesDaClinica.contains(cliente)) {
            cliente.atualizarDados(nome, endereco, telefone);
        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
    }

    public ArrayList<Cliente> getParteClientesDaClinica(int[] numeros) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (int numero : numeros) {
            clientes.add(clientesDaClinica.get(numero - 1));
        }
        return clientes;
    }

    // remove cliente
    public void removerCliente(Cliente cliente) {
        if(clientesDaClinica.contains(cliente)) {
            clientesDaClinica.remove(cliente);
            cliente.enviarNotificacao("Cliente removido com sucesso!");
        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
    }


    // get lista de clientes
    public ArrayList<Cliente> getClientesDaClinica() {
        return this.clientesDaClinica;
    }

    // update animal do cliente
    public void atualizarAnimal(Animal animal, String nome, Especie especie, String raca, java.util.Date dataNascimento) {
        if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }

        animal.atualizarDados(nome, especie, raca, dataNascimento);
    }

    // remover animal do cliente
    public void removerAnimal(Animal animal, Cliente cliente) {
        if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }
        if (cliente == null) {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
        cliente.removerAnimal(animal.getId());
    }

    // adicionar animal ao cliente
    public void adicionarAnimal(Animal animal, Cliente cliente) {
        if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");
        }
        if (cliente == null) {
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
        for (Consulta consulta : consultasDaClinica) {
            consulta.exibirDados(true);
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

    //CREATE - produto
    public void adicionarProduto(Produto produto) {
        produtosDaClinica.add(produto);
        System.out.println("Produto adicionado: " + produto.getNome());
    }

    //REMOVE - produto
    public void removerProduto(Produto produto) {
        produtosDaClinica.remove(produto);
    }

    //return list
    public ArrayList<Produto> getProdutosDaClinica() {
        return this.produtosDaClinica;
    }

    //READ - leitura do nome do produto para verificar no container
    public void LerProds(int limite) {
        if (limite > 0) {
            System.out.println("Lista de produtos limitada em " + limite);
            for (int i = 0; i < limite; i++) {
                produtosDaClinica.get(i).imprimirDados();
            }
        } else {
            for (Produto produto : produtosDaClinica) {
                produto.imprimirDados();
            }
        }
    }

    //UPGRADE - atualizar dados 
    public void atualizaProd(Produto produto, String nome, String desc, float preco, int etq) {
        Produto produtoClinica = produtosDaClinica.stream()
                .filter(produtoAntigo -> produtoAntigo.getId() == produto.getId())
                .findFirst()
                .orElse(null);

        if (produtoClinica != null) {
            produtoClinica.atualizarDados(nome, desc, preco, etq);

        }
    }

    public void adicionarServico(Servico servico) {
        servicosDaClinica.add(servico);
    }

    public void listarServicos() {
        for (Servico servico : servicosDaClinica) {
            servico.imprimirDados();
        }
    }

    public ArrayList<Servico> getServicosDaClinica() {
        return servicosDaClinica;
    }

    public void removerServico(Servico servico) {
        servicosDaClinica.remove(servico);
    }

    public void adicionarPlano(PlanoPet planoPet) {
        planosDaClinica.add(planoPet);
    }

    public void listarPlanos() {
        for (PlanoPet planoPet : planosDaClinica) {
            planoPet.imprimirDados();
        }
    }

    public ArrayList<PlanoPet> getPlanosDaClinica() {
        return planosDaClinica;
    }

    public void removerPlanoPet(PlanoPet planoPet) {
        servicosDaClinica.remove(planoPet);
    }

}
