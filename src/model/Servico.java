package model;

import exception.DescontoInvalidoException;
import java.util.ArrayList;

public class Servico extends ItemComercial {

    private ArrayList<Funcionario> listaDeFuncionarios;
    private Animal animal;

    Servico(int id, String nome, String desc, float preco, Animal animal, ArrayList<Funcionario> listaDeFuncionarios) {
        super(id, nome, desc, preco);

        this.animal = animal;

        if (listaDeFuncionarios != null) {
            this.listaDeFuncionarios = listaDeFuncionarios;
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

    @Override
    public void imprimirDados() {
        System.out.print("[ Nome: " + this.getNome() + " | " + this.getPreco() + " ] - Funcionarios: ");
        for (Funcionario f : listaDeFuncionarios) {
            System.out.print(f.getNome() + "; ");
        }
        System.out.println("\n");
    }

    public Animal getAnimal(Clinica clinica) {
        return this.animal;
    }
}
