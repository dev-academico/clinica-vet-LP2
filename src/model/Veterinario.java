package model;

import exception.DadosObrigatoriosException;
import exception.SalarioInvalidoException;

public class Veterinario extends Pessoa {

    private float salario;
    private String CRMV;

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
    }

    public void registrarAtendimento() {
        //Implementar
    }

    public void gerenciarAgendamentos() {
        //Implementar
    }

    public void atualizarDados(String nome, String endereco, String telefone, float salario, String CRMV) {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
        if (CRMV == null) {
            throw new DadosObrigatoriosException("Um veterinário deve ter um CRMV obrigatoriamente.");
        }
        this.salario = salario;
        this.CRMV = CRMV;
        super.atualizarDados(nome, endereco, telefone); //sobrecarga do pai
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Salario: " + this.salario);
        System.out.println("CRM: " + this.CRMV);
    }

    public String getCRMV() {
        return CRMV;
    }

    public float getSalario() {
        return salario;
    }
}
