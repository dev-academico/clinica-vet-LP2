package model;

import java.util.ArrayList;

public class Clinica {
    private ArrayList<Veterinario> veterinariosDaClinica = new ArrayList<>();

    public Clinica() {};

    //create Veterinário
    public void adicionarVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.add(veterinario);
    }

    //remove Veterinário
    public void removerVeterinário(Veterinario veterinario) {
        veterinariosDaClinica.remove(veterinario);
    }

    //update Veterinário
    public void atualizarVeterinário(String nome, String cpf, String endereco, String telefone, float salario, String CRMV) {
        for(Veterinario veterinarioIndividual : veterinariosDaClinica){
            if(veterinarioIndividual.getCRMV().equals(CRMV)){
                veterinarioIndividual.atualizarDados(nome, cpf, endereco, telefone, salario, CRMV);
            }
        }
    }

    //read Veterinario
    public void lerVeterinário(String CRMV){
        for(Veterinario veterinario : veterinariosDaClinica){
            if(veterinario.getCRMV().equals(CRMV)){
                veterinario.exibirDados();
            }
        }
    }

}