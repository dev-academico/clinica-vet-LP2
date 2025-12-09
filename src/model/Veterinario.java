package model;

import Interfaces.INotificavel;
import Interfaces.IValidavel;
import exception.DadosObrigatoriosException;
import exception.SalarioInvalidoException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Veterinario extends Pessoa implements INotificavel, IValidavel {

    @Override
    public boolean validarCreate() {

        if(getNome() == null || getNome().trim().isEmpty()) {
            return false;
        }
        if(getCpf() == null || getCpf().trim().isEmpty()) {
            return false;
        }
        if(getEndereco() == null || getEndereco().trim().isEmpty()) {
            return false;
        }
        if(getTelefone() == null || getTelefone().trim().isEmpty()) {
            return false;
        }
        if(salario <= 0) {
            return false;
        }
        if(CRMV == null || CRMV.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    private float salario;
    private final String CRMV;
    private ArrayList<Consulta> listaDeConsultas;

    public Veterinario(String nome, String cpf, String endereco, String telefone, float salario, String CRMV) throws DadosObrigatoriosException {
        super(nome, cpf, endereco, telefone);
        if (CRMV == null) {
            throw new DadosObrigatoriosException("Um veterinário deverá ter pelo menos um animal.");
        }
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        this.CRMV = CRMV;
        this.listaDeConsultas = new ArrayList<>();

        if(!validarCreate()) {
            throw new DadosObrigatoriosException("Dados Obrigatorios! Todos os campos (nome, cpf, endereco, telefone, sálario e CRMV) são obrigatórios");
        }
    }

    public void registrarConsulta(Consulta consulta) {
        this.listaDeConsultas.add(consulta);
    }

    public void mostrarConsultas() {
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        System.out.println("-- Consultas");

        if (this.listaDeConsultas.isEmpty()) {
            System.out.println(RED + "-- Nenhuma consulta registrada. " + RESET);
            return;
        }

        for (Consulta consulta : this.listaDeConsultas) {
            System.out.println(RED + "[Consulta ID: " + consulta.getId() + ", Descrição: " + consulta.getDescricao() + ", Data: " + consulta.getData() + ", Animal: " + consulta.getAnimal().getNome() + "| Status: " + consulta.getStatus() + "]" + RESET);
        }
    }

    public void atualizarDados(String nome, String endereco, String telefone, float salario) {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        super.atualizarDados(nome, endereco, telefone); //sobrecarga do pai
    }

    public void exibirDados(Boolean mostrarDetalhes) {
        String BLUE = "\u001B[34m";
        String RESET = "\u001B[0m";
        if (!mostrarDetalhes) {
            System.out.println(BLUE + "[" + this.getNome() + "|" + this.getCRMV() + "]" + RESET);
            return;
        }

        System.out.println(BLUE + "[" + this.getNome() + "|" + this.getCRMV() + "|" + this.getCpf() + "|" + this.getEndereco() + "|" + this.getTelefone() + "|" + this.getSalario() +  "]" + RESET);
        System.out.println("-- Lista de Consultas:");
        mostrarConsultas();
    }

    public String getCRMV() {
        return CRMV;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.print("Mensagem: " + mensagem + " ");
        this.exibirDados();
    }
}
