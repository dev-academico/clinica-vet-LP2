package model;

import exception.AnimalInexistenteException;
import exception.DadosObrigatoriosException;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa {
    private ArrayList<Animal> listaDeAnimais;

    public Cliente(String nome, String cpf, String endereco, String telefone, ArrayList<Animal> listaDeAnimais) throws DadosObrigatoriosException {
        super(nome, cpf, endereco, telefone);
        if (listaDeAnimais == null) {
            throw new DadosObrigatoriosException("Um cliente deverá ter pelo menos um animal");
        }
        this.listaDeAnimais = listaDeAnimais;
    }

    public void agendarConsulta() {
        // Implementar
    }

    public void atualizarDados(String nome, String endereco, String telefone, ArrayList<Animal> listaDeAnimais) {
        if (listaDeAnimais == null) {
            throw new DadosObrigatoriosException("Um cliente deverá ter pelo menos um animal");
        } 
        this.listaDeAnimais = listaDeAnimais;
        super.atualizarDados(nome, endereco, telefone); //sobrecarga do pai
    }

    @Override
    public void exibirDados() {
        // Dados do cliente
        super.exibirDados();

        // Dados dos animais
        System.out.println();
        System.out.println("Lista de Animais do Cliente:");
        for (Animal animal : listaDeAnimais) {
            this.mostrarAnimal(animal.getId());
        }
    }

    // CRUD de animais do cliente
    public void adicionarAnimal(Animal animal) {
        this.listaDeAnimais.add(animal);
    }

    public void removerAnimal(int id) {
        this.listaDeAnimais.removeIf(animal -> animal.getId() == id);
    }

    public void atualizarAnimal(int id, String nome, Especie especie, String raca, Date dataNascimento) {
        Animal animalParaAtualizar = this.listaDeAnimais.stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);

        if (animalParaAtualizar != null) {
            animalParaAtualizar.atualizarDados(nome, especie, raca, dataNascimento);
        } else {
            throw new AnimalInexistenteException("Animal de ID: " + id + " , não foi encontrado");
        }
    }

    public void mostrarAnimal(int id) {
        Animal animalParaMostrar = this.listaDeAnimais.stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);

        if (animalParaMostrar != null) {
            animalParaMostrar.exibirAnimal();
        } else {
            throw new AnimalInexistenteException("Animal de ID: " + id + " , não foi encontrado");
        }
    }

    public void registrarPesoAnimal(int id, float peso) {
        Animal animalParaAtualizar = this.listaDeAnimais.stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);

        if (animalParaAtualizar != null) {
            animalParaAtualizar.registrarPeso(peso);
        } else {
            throw new AnimalInexistenteException("Animal de ID: " + id + " , não foi encontrado");
        }
    }

    public void registrarObservacaoAnimal(int id, String observacao) {
        Animal animalParaAtualizar = this.listaDeAnimais.stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);

        if(animalParaAtualizar != null) {
            animalParaAtualizar.registrarObservacao(observacao);
        } else {
            throw new AnimalInexistenteException("Animal de ID: " + id + " , não foi encontrado"); 
        }
    }

    public ArrayList<Animal> getAnimais() {
        return this.listaDeAnimais;
    }
}
