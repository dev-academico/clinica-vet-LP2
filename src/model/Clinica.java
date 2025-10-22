package model;

import exception.ClienteInexistenteException;
import java.util.ArrayList;

public class Clinica {
    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();
    private ArrayList<Funcionario> funcionariosDaClinica = new ArrayList<>();
    private ArrayList<Cliente> clientesDaClinica = new ArrayList<>();

    public Clinica() {};

    //create Veterinário
    public void adicionarVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.add(veterinario);
        System.out.println("Veterinário adicionado com sucesso!");
    }

    //remove Veterinário
    public void removerVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.remove(veterinario);
        System.out.println("Veterinário removido com sucesso!");
    }

    //update Veterinário
    public void atualizarVeterinário(String nome, String endereco, String telefone, float salario, String CRMV) {
        for(Veterinario veterinarioIndividual : veterinariosDaClinica){
            if(veterinarioIndividual.getCRMV().equals(CRMV)){
                veterinarioIndividual.atualizarDados(nome,  endereco, telefone, salario, CRMV);
            }
        }
        System.out.println("Veterinário atualizado com sucesso!");
    }

    //read Veterinario
    public void lerVeterinário(String CRMV){
        for(Veterinario veterinario : veterinariosDaClinica){
            if(veterinario.getCRMV().equals(CRMV)){
                veterinario.exibirDados();
            }
        }
    }

    //create funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionariosDaClinica.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    //remove funcionário
    public void removerFuncionario(Funcionario funcionario) {
        funcionariosDaClinica.remove(funcionario);
        System.out.println("Funcionário removido com sucesso!");
    }

    //update funcionario
    public void atualizarFuncionario(String nome, String endereco, String telefone, float salario, String identificadorCarteiraTrabalho, Cargo cargo) {
        for(Funcionario funcionarioIndividual : funcionariosDaClinica){
            if(funcionarioIndividual.getIdentificadorCarteiraTrabalho().equals(identificadorCarteiraTrabalho)){
                funcionarioIndividual.atualizarDados(nome, endereco, telefone, salario, identificadorCarteiraTrabalho, cargo);
            }
        }
        System.out.println("Funcionário atualizado com sucesso!");
    }

    //read funcionario
    public void lerFuncionario(String identificadorCarteiraDeTrabalho){
        for(Funcionario funcionarioIndividual : funcionariosDaClinica){
            if(funcionarioIndividual.getIdentificadorCarteiraTrabalho().equals(identificadorCarteiraDeTrabalho)){
                funcionarioIndividual.exibirDados();
            }
        }
    }

    // create cliente
    public void adicionarCliente(Cliente cliente) {
        clientesDaClinica.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    // listar clientes
    public void listarClientes() {
        System.out.println("Lista de Clientes da Clínica:");
        for(Cliente cliente : clientesDaClinica){
            System.out.println("/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/");
            cliente.exibirDados();
            System.out.println("/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/");
        }
    }

    // read cliente
    public Cliente lerCliente(String cpf){
        Cliente clienteEncontrado = clientesDaClinica.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().orElse(null);
        if(clienteEncontrado != null) {
            return clienteEncontrado;
        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
    }

    // update cliente
    public void atualizarCliente(String nome, String endereco, String telefone, ArrayList<Animal> listaDeAnimais, String cpf) {
        Cliente clienteClinica = clientesDaClinica.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().orElse(null);

        if (clienteClinica != null) {
            clienteClinica.atualizarDados(nome, endereco, telefone, listaDeAnimais);
        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
    }

}