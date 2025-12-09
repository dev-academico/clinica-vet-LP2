package model;

import Interfaces.INotificavel;
import Interfaces.IValidavel;
import exception.DadosObrigatoriosException;
import exception.SalarioInvalidoException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Funcionario extends Pessoa implements INotificavel, IValidavel {

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
        if(this.identificadorCarteiraTrabalho == null || this.identificadorCarteiraTrabalho.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    private float salario;
    private final String identificadorCarteiraTrabalho;
    private Cargo cargo;
    private ArrayList<Servico> listaDeServicos;

    public Funcionario(String nome, String cpf, String endereco, String telefone, float salario, String identificadorCarteiraTrabalho, Cargo cargo) throws DadosObrigatoriosException {
        super(nome, cpf, endereco, telefone);
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        this.identificadorCarteiraTrabalho = identificadorCarteiraTrabalho;
        this.cargo = cargo;
        this.listaDeServicos = new ArrayList<>();

        if(!validarCreate()) {
            throw new DadosObrigatoriosException("Dados Obrigatorios! Todos os campos (nome, cpf, endereco, telefone, sálario, careteira de trabalho e cargo) são obrigatórios");
        }
    }

    public void registrarServico(Servico servico) {
        this.listaDeServicos.add(servico);
    }

    public void mostraServicos() {
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        if (this.listaDeServicos.isEmpty()) {
            System.out.println(RED + "-- Nenhum serviço registrado. " + RESET);
            return;
        }

        for (Servico servico : this.listaDeServicos) {
            System.out.println(RED + "-- [ Serviço: " + servico.getDescricao() + " | Preço: " + servico.getPreco() + " ]" + RESET);
        }
    }

    public void atualizarDados(String nome, String endereco, String telefone, float salario, Cargo cargo) {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um funcionário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        this.cargo = cargo;

        super.atualizarDados(nome, endereco, telefone); //sobrecarga do pai
    }

    public void exibirDados(Boolean mostrarDetalhes) {
        final String BLUE = "\u001B[34m";
        final String RESET = "\u001B[0m";
        if (!mostrarDetalhes) {
            System.out.println(BLUE + "[ Nome: " + this.getNome() + " | CPF: " + this.getCpf() + " | Endereço: " + this.getEndereco() + " | Telefone: " + this.getTelefone() + " | Salário: " + this.salario + " | Identificador Carteira de Trabalho: " + this.identificadorCarteiraTrabalho + " | Cargo: " + this.cargo + " ]" + RESET);
        } else {
            System.out.println(BLUE + "[ Nome: " + this.getNome() + " | CPF: " + this.getCpf() + " | Endereço: " + this.getEndereco() + " | Telefone: " + this.getTelefone() + " | Salário: " + this.salario + " | Identificador Carteira de Trabalho: " + this.identificadorCarteiraTrabalho + " | Cargo: " + this.cargo + " ]" + RESET);
            System.out.println("-- Lista de Serviços:");
            mostraServicos();
        }

    }

    public String getIdentificadorCarteiraTrabalho() {
        return this.identificadorCarteiraTrabalho;
    }


    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.print("Mensagem: " + mensagem + " ");
        this.exibirDados();
    }
}
