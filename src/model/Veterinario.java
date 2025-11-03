package model;

import exception.DadosObrigatoriosException;
import exception.SalarioInvalidoException;

import java.util.ArrayList;

public class Veterinario extends Pessoa {

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
    }

    public void registrarConsulta(Consulta consulta) {
        this.listaDeConsultas.add(consulta);
    }

    public void atualizarDados(String nome, String endereco, String telefone, float salario) {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Um veterinário deverá ter um salário positivo e pelo menos maior que zero.");
        }
        this.salario = salario;
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
