package model;

import Interfaces.IValidavel;
import exception.DadosObrigatoriosException;
import exception.DescontoInvalidoException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Servico extends ItemComercial implements IValidavel {

    @Override
    public boolean validarCreate() {

        if (getNome().trim().isEmpty()) {
            return false;
        }
        if (getDescricao().trim().isEmpty()) {
            return false;
        }
        if (getAnimal() == null) {
            return false;
        }
        if(getPreco() <= 0) {
            return false;
        }

        return true;
    }

    private ArrayList<Funcionario> listaDeFuncionarios;
    private Animal animal;

    Servico(int id, String nome, String desc, float preco, Animal animal, ArrayList<Funcionario> listaDeFuncionarios) {
        super(id, nome, desc, preco);
        this.animal = animal;
        this.listaDeFuncionarios = listaDeFuncionarios;

        if(!this.validarCreate()){
            throw new DadosObrigatoriosException("Dados Obrigatorios! Todos os campos (nome, descrição, preço, animal e lista de funcionários) são obrigatórios");
        }

    }

    @Override
    public boolean aplicarDesconto(Double valorDesconto) {
        try {
            DescontoInvalidoException.validaPercentual(valorDesconto);
            float valorDescontoFloat = valorDesconto.floatValue();
            float preco_novo = valorDescontoFloat * this.getPreco();

            System.out.print("Desconto aplicado: " + valorDescontoFloat * 100 + "% |\nPreço a pagar (não inclui taxas): " + preco_novo);
            System.out.println("\n");
            return true;
        } catch (DescontoInvalidoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void atualizarDados(String nome, String desc, float preco, Animal animal, ArrayList<Funcionario> listaDeFuncionarios){
        if(nome.trim().isEmpty() || desc.isEmpty() || preco <= 0 || animal == null || listaDeFuncionarios == null) {
            throw new DadosObrigatoriosException("Dados Obrigatorios! Todos os campos (nome, descrição, preço, animal e lista de funcionários) são obrigatórios");
        }
        this.setNome(nome);
        this.setDesc(desc);
        this.setPreco(preco);

        this.animal=animal;
        this.listaDeFuncionarios=listaDeFuncionarios;
        System.out.println("\nServiço: "+nome+" | Dados atualizados com sucesso!");
        
    }



    @Override
    public void imprimirDados() {
        System.out.print("[ Nome: " + this.getNome() + " | " + this.getPreco() + " ] - Funcionarios: ");
        for (Funcionario f : listaDeFuncionarios) {
            System.out.print(f.getNome() + "; ");
        }
        System.out.println();
    }



    public Animal getAnimal() {
        return this.animal;
    }
}
