package model;

import java.util.ArrayList;

public class Clinica {
    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();
    private ArrayList<Funcionario> funcionariosDaClinica = new ArrayList<>();

    public Clinica() {};

    //create Veterinário
    public void adicionarVeterinário(Veterinario veterinario) {
        try{
            veterinariosDaClinica.add(veterinario);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Veterinário adicionado com sucesso!");
    }

    //remove Veterinário
    public void removerVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.remove(veterinario);
        System.out.println("Veterinário removido com sucesso!");
    }

    //update Veterinário
    public void atualizarVeterinário(String nome, String cpf, String endereco, String telefone, float salario, String CRMV) {
        for(Veterinario veterinarioIndividual : veterinariosDaClinica){
            if(veterinarioIndividual.getCRMV().equals(CRMV)){
                veterinarioIndividual.atualizarDados(nome, cpf, endereco, telefone, salario, CRMV);
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
    public void atualizarFuncionario(String nome, String cpf, String endereco, String telefone, float salario, String identificadorCarteiraTrabalho, Cargo cargo) {
        for(Funcionario funcionarioIndividual : funcionariosDaClinica){
            if(funcionarioIndividual.getIdentificadorCarteiraTrabalho().equals(identificadorCarteiraTrabalho)){
                funcionarioIndividual.atualizarDados(nome, cpf, endereco, telefone, salario, identificadorCarteiraTrabalho, cargo);
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

}