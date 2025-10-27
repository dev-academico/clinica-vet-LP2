package model;

import java.util.Map;
import java.util.Scanner;
//import java.util.ArrayList;

//adicionando modificações
abstract class ItemComercial {
    static private int contItem=0;

    private Integer id;
    private String nome;//talvez seja melhor final
    private String desc;

    ItemComercial(Integer id, String nome, String desc){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        contItem++;
    }

    public String getNome(){
        return this.nome;
    }

    public Integer getCod(){
        return this.id;
    }
    //ovr
    public abstract boolean aplicarDesconto(Double v);

}