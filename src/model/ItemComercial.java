package model;

import exception.DescontoInvalidoException;
import exception.DescontoInvalidoException;

import java.util.HashMap;

public class ItemComercial {
    static private int contItem=0;

    final private Integer id;
    final private String nome;
    private String desc;
    private HashMap<Integer, Veterinario> responsaveisServ;

    ItemComercial(Integer id, String nome, String desc, Veterinario fnr, HashMap<Integer, Veterinario> responsaveisServ){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        this.contItem+=1;
        this.responsaveisServ=responsaveisServ;
    }

    //uso de polim. aq ↓
    public boolean aplicarDesconto(Double v) throws DescontoInvalidoException {
        boolean apply=false;

        try{
            DescontoInvalidoException.validaPercentual(v);
            //impl logica do produto/serv. a ser descontado nas classes
            apply=true;
            return apply;
        }catch(DescontoInvalidoException e){
            System.out.println(e.getMessage());
            return apply;
        }
    }

    //Identifica um serviço e um responsável
    public void incluiFuncionario(Veterinario F){
        HashMap itemC = new HashMap<Integer, Veterinario>(); //Necessário um getter
        System.out.println("Funcionário do responsável pelo serviço: "+this.nome+" é" +
                F.getNome());
        //implementar: controle para identificar se é produto ou não
    }
    public boolean consumoItem(){
        //mostra se um cliente consumiu um prod. ou serviço
        boolean cons=false;

        return cons;
    }
}