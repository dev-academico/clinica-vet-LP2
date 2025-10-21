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
        // Dados do cliente
        super.exibirDados();
        // Dados dos animais
        System.out.println("-------------- Animais ---------------");
        for (Animal animal : this.listaDePets) {
            animal.exibirAnimal();
        }
    }

    public void registrarPesoAnimal(int id, float peso) {
        for(Animal animal: this.listaDePets) {
            if(animal.getId() == id) {
                animal.registrarPeso(peso);
            }
        }
    }

    public void registrarObservacaoAnimal(int id, String observacao) {
        for(Animal animal: this.listaDePets) {
            if(animal.getId() == id) {
                animal.registrarObservacao(observacao);
            }
        }
    }
}
