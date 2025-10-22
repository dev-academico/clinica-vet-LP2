package model;

import exception.DadosObrigatoriosException;
import exception.SalarioInvalidoException;

public class Funcionario extends Pessoa {
    private float salario;
    private String identificadorCarteiraTrabalho;
    private Cargo cargo;

    public Funcionario(String nome, String cpf, String endereco, String telefone, float salario, String identificadorCarteiraTrabalho, Cargo cargo) throws DadosObrigatoriosException {
        super(nome, cpf, endereco, telefone);
        if (identificadorCarteiraTrabalho == null) {
            throw new DadosObrigatoriosException("Um funcionário deverá ter um identificador de carteira de trabalho.");
        }
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        this.identificadorCarteiraTrabalho = identificadorCarteiraTrabalho;
        this.cargo = cargo;
    }
    public void atualizarDados(String nome, String endereco, String telefone, float salario, String identificadorCarteiraTrabalho, Cargo cargo) {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um funcionário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        if(identificadorCarteiraTrabalho == null) {
            throw new DadosObrigatoriosException("Um funcionário deve ter um identificador de carteira de trabalho obrigatoriamente.");
        }
        this.salario = salario;
        this.identificadorCarteiraTrabalho = identificadorCarteiraTrabalho;
        this.cargo = cargo;

        super.atualizarDados(nome, endereco, telefone); //sobrecarga do pai
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Salario: " + this.salario);
        System.out.println("Identificador de carteira de trabalho: " + this.identificadorCarteiraTrabalho);
    }

    public String getIdentificadorCarteiraTrabalho() {return this.identificadorCarteiraTrabalho;}
}
