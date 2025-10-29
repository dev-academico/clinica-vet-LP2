package model;

import exception.DescontoInvalidoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Servico extends ItemComercial{

    private ArrayList<Funcionario> listaDeFuncionarios;
    private int idAnimal;
    private String cpfPessoa;

    Servico(int id, String nome, String desc, float preco, int idAnimal,String cpfPessoa, ArrayList<Funcionario> listaDeFuncionarios) {
        super(id, nome, desc, preco);

        this.idAnimal = idAnimal;
        this.cpfPessoa = cpfPessoa;

        if(listaDeFuncionarios != null){
            this.listaDeFuncionarios = listaDeFuncionarios;
        }

    }

    @Override
    public boolean aplicarDesconto(Double valorDesconto){
         try {
             DescontoInvalidoException.validaPercentual(valorDesconto);
            float valorDescontoFloat= valorDesconto.floatValue();
            float preco_novo = valorDescontoFloat * this.getPreco();

            System.out.print("Desconto aplicado: "+ valorDescontoFloat * 100 +"% |\nPreço a pagar (não inclui taxas): " + preco_novo);
            System.out.println("\n");
            return true;
         } catch(DescontoInvalidoException e){
            System.out.println(e.getMessage());
            return false;
         }
    }

    @Override
    public void imprimirDados(){
        System.out.print("[ Nome: " + this.getNome() + " | " + this.getPreco() + " ] - Funcionarios: ");
        for (Funcionario f : listaDeFuncionarios){
            System.out.print(f.getNome() + "; ");
        }
        System.out.println("\n");
    }

    public Animal getAnimal(Clinica clinica){
        return clinica.getAnimal(this.cpfPessoa, this.idAnimal);
    }
}