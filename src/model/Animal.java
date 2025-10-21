package model;

import java.util.Date;

public class Animal {
    static public int animalCount = 0;

    private String nome;
    private Especie especie;
    private String raca;
    private Date dataNascimento;
    private Float peso;
    private final int id;

    private String observacao;

    public Animal(String nome, Especie especie, String raca, Date dataNascimento, Float peso, String observacao) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.observacao = observacao;
        this.id = animalCount++;
    }

    void registrarPeso(Float peso) {
        this.peso = peso;
    }

    void registrarObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    void exibirAnimal() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + nome);
        System.out.println("Especie: " + especie);
        System.out.println("Raca: " + raca);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Peso: " + peso);
        System.out.println("--------------------------------------");
        System.out.println("Observacao: " + observacao);
    }
}
