package model;

import Interfaces.IValidavel;
import exception.DadosObrigatoriosException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class PlanoPet extends ItemComercial implements IValidavel {

    @Override
    public boolean validarCreate() {
        if(getNome() == null || getNome().trim().isEmpty()) {
            return false;
        }
        if (getDescricao() == null || getDescricao().trim().isEmpty()) {
            return false;
        }
        if (getPreco() <= 0) {
            return false;
        }
        if(tipoPlano == null || tipoPlano.trim().isEmpty()) {
            return false;
        }
        if(termos.isEmpty()) {
            return false;
        }

        return true;
    }


    private ArrayList<String> termos;
    private String tipoPlano;
    private ArrayList<Animal> animals;

    public PlanoPet(int id, String nome, String descricao, Float preco, String tipoPlano, ArrayList<String> termos) {
        super(id, nome, descricao, preco);
        this.tipoPlano = tipoPlano;
        this.termos = termos;
        this.animals = new ArrayList<>();

        if(!validarCreate()) {
            throw new DadosObrigatoriosException("Dados incorretos! Todos os campos (nome, descrição, preço, tipo de plano e termos) são obrigátorios!");
        }
    }

    public void AtualizarPlanoPet(String nome, String descricao, Float preco, String tipoPlano, ArrayList<String> termos) {
        setNome(nome);
        setDesc(descricao);
        setPreco(preco);

        this.tipoPlano = tipoPlano;
        this.termos = termos;
    }

    public void ListarAnimais() {
        System.out.println("Animals no plano:");
        for (Animal a : animals) {
            System.out.print("[ " + (animals.indexOf(a)+1) + " ] ");
            a.exibirAnimal();
        }
    }

    public Animal getAnimal(int id) {
        return animals.get(id);
    }

    public int getAnimalSize() {
        return animals.size();
    }

    public void AdicionarAnimal(Animal animal) {
        for  (Animal a : animals) {
            if(a.getId() == animal.getId()) {
                throw new InvalidParameterException("Animal já adicionado!");
            }
        }
        this.animals.add(animal);
    }

    public void RemoverAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public boolean aplicarDesconto(Double v) {
        if (v >= 0) {
            setPreco((float) (getPreco()*v));
        }
        return false;
    }

    public void imprimir() {
        System.out.println("[ id: " +  getID() + " | nome: " + getNome() + " | preço: " + getPreco() + " | tipo: " + this.tipoPlano + " ]");
    }

    @Override
    public void imprimirDados() {
        System.out.println("[ id: " +  getID() + " | nome: " + getNome() + " | preço: " + getPreco() + " | tipo: " + this.tipoPlano + " ]");
        System.out.println("[ Termos ] ");
        for(String termo : termos) {
            System.out.println(termos.indexOf(termo) + ". " + termo);
        }
        System.out.println("[ Animals ] ");
        for(Animal a : animals) {
            a.exibirAnimal();
        }
    }
}
