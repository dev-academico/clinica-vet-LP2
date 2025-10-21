package model;

import exception.DadosObrigatoriosException;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Animal> listaDePets;

    public Cliente(String nome, String cpf, String endereco, String telefone, ArrayList<Animal> listaDePets) throws DadosObrigatoriosException {
        super(nome, cpf, endereco, telefone);
        if (listaDePets == null) {
            throw new DadosObrigatoriosException("Um cliente deverá ter pelo menos um animal");
        }
        this.listaDePets = listaDePets;
    }

    public void agendarConsulta() {
        // Implementar
    }

    public void atualizarDados(String nome, String cpf, String endereco, String telefone, ArrayList<Animal> listaDePets) {
        this.listaDePets = listaDePets;
        super.atualizarDados(nome, cpf, endereco, telefone); //sobrecarga do pai
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        for (Animal animal : this.listaDePets) {
            System.out.println(animal);
        }
    }

}
