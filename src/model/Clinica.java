package model;

import exception.AnimalInexistenteException;
import exception.ClienteInexistenteException;
import java.util.ArrayList;

public class Clinica {
    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();
    private ArrayList<Funcionario> funcionariosDaClinica = new ArrayList<>();
    private ArrayList<Cliente> clientesDaClinica = new ArrayList<>();

    public Clinica() {
    };

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

    // read funcionario
    public void lerFuncionario(String identificadorCarteiraDeTrabalho) {
        for (Funcionario funcionarioIndividual : funcionariosDaClinica) {
            if (funcionarioIndividual.getIdentificadorCarteiraTrabalho().equals(identificadorCarteiraDeTrabalho)) {
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
        for (Cliente cliente : clientesDaClinica) {
            System.out.println("-----");
            cliente.exibirDados();
            System.out.println("-----");
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
    public void removerCliente(String cpf) {
        Cliente clienteClinica = clientesDaClinica.stream()
                .filter(clienteAntigo -> clienteAntigo.getCpf().equals(cpf)).findFirst().orElse(null);

        if (clienteClinica != null) {
            clientesDaClinica.remove(clienteClinica);
            System.out.println("Cliente removido com sucesso!");

        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");

        }
    }

    // get lista de clientes
    public ArrayList<Cliente> getClientesDaClinica() {
        return this.clientesDaClinica;
    }

    // get animal
    public Animal getAnimal(String cpfPessoa, int idAnimal) throws AnimalInexistenteException {
        for (Cliente cliente : clientesDaClinica) {
            if (cliente.getCpf().equals(cpfPessoa)) {
                for ( Animal animal : cliente.getAnimais()) {
                    if(animal.getId() == idAnimal) {
                        return animal;
                    }
                }
            }
        }
        throw new AnimalInexistenteException("Animal não encontrado");
    }

    // update animal do cliente
    public void atualizarAnimal(Animal animal, String nome, Especie especie, String raca, java.util.Date dataNascimento) {
        if (animal != null) {
            animal.atualizarDados(nome, especie, raca, dataNascimento);
            System.out.println("Animal atualizado com sucesso!");

        } else {
            throw new AnimalInexistenteException("Animal não encontrado");

        }
    }
    
    // remover animal do cliente
    public void removerAnimal(Animal animal) {
        if (animal != null) {
            Cliente cliente = this.clientesDaClinica.stream()
                    .filter(cliente1 -> cliente1.getCpf().equals(animal.getCpfCliente()))
                    .findFirst()
                    .orElse(null);
            if (cliente != null) {
                cliente.removerAnimal(animal.getId());
                System.out.println("Animal removido com sucesso!");
            } else {
                throw new ClienteInexistenteException("Cliente não encontrado");
            }

        } else if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");

        }
    }

    // adicionar animal ao cliente
    public void adicionarAnimal(Animal animal) {
        if (animal != null) {
            Cliente cliente = this.clientesDaClinica.stream()
                    .filter(cliente1 -> cliente1.getCpf().equals(animal.getCpfCliente()))
                    .findFirst()
                    .orElse(null);
            if (cliente != null) {
                cliente.adicionarAnimal(animal);
                System.out.println("Animal adicionado com sucesso!");
            } else {
                throw new ClienteInexistenteException("Cliente não encontrado");
            }

        } else if (animal == null) {
            throw new AnimalInexistenteException("Animal não encontrado");

        }
    }

    public void listarAnimaisDoCliente(Cliente cliente) {
        if (cliente != null) {
            cliente.mostrarListaDeAnimais();
        } else {
            throw new ClienteInexistenteException("Cliente não encontrado");
        }
    }
}