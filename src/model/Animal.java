package model;

import java.util.ArrayList;
import java.util.Date;

public class Animal {
    static public int animalCount = 0;

    private final int id;

    private Cliente cliente;

    private String nome;
    private Especie especie;
    private String raca;
    private Date dataNascimento;
    private Float peso;
    private String observacao;

    private ArrayList<Servico> listaDeServicos = new ArrayList<Servico>();
    private ArrayList<Consulta> listaDeConsultas = new ArrayList<Consulta>();

    public Animal(String nome, Especie especie, String raca, Date dataNascimento, Cliente cliente) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.id = animalCount++;
        this.cliente = cliente;
    }

    void registrarPeso(Float peso) {
        this.peso = peso;
    }

    void registrarObservacao(String observacao) {
        this.observacao = observacao;
    }

    void atualizarDados(String nome, Especie especie, String raca, Date dataNascimento) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    void exibirAnimal() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + nome);
        System.out.println("Especie: " + especie);
        System.out.println("Raca: " + raca);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Peso: " + peso);
        System.out.println("Observacao: " + observacao);
    }

    // Servico methods
    void adicionarServico(Servico servico) {
        this.listaDeServicos.add(servico);
    }

    void removerServico(Servico servico) {
        this.listaDeServicos.remove(servico);
    }

    void exibirServicos() {
        System.out.println("Serviços associados ao animal " + this.nome + ":");
        for (Servico servico : listaDeServicos) {
            System.out.println("Serviço ID: 123");
        }
    }

    // Consulta methods
    void adicionarConsulta(Consulta consulta) {
        this.listaDeConsultas.add(consulta);
    }

    void removerConsulta(Consulta consulta) {
        this.listaDeConsultas.remove(consulta);
    }

    void exibirConsultas() {
        System.out.println("Consultas associadas ao animal " + this.nome + ":");
        for (Consulta consulta : listaDeConsultas) {
            System.out.println("Consulta ID: 123");
        }
    }
}
