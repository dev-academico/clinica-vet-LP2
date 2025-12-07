package model;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class PlanoPet extends ItemComercial {
    private ArrayList<String> termos;
    private String tipoPlano;
    private ArrayList<Animal> animais;

    public PlanoPet(int id, String nome, String descricao, Float preco, String tipoPlano, ArrayList<String> termos) {
        super(id, nome, descricao, preco);
        this.tipoPlano = tipoPlano;
        this.termos = termos;
        this.animais = new ArrayList<>();
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
        for (Animal a : animais) {
            System.out.print("[ " + (animais.indexOf(a)+1) + " ] ");
            a.exibirAnimal();
        }
    }

    public Animal getAnimal(int id) {
        return animais.get(id);
    }

    public int getAnimalSize() {
        return animais.size();
    }

    public void AdicionarAnimal(Animal animal) {
        for  (Animal a : animais) {
            if(a.getId() == animal.getId()) {
                throw new InvalidParameterException();
            }
        }
        this.animais.add(animal);
    }

    public void RemoverAnimal(Animal animal) {
        this.animais.remove(animal);
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
        for(Animal a : animais) {
            a.exibirAnimal();
        }
    }
}
