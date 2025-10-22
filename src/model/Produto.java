package model;

import java.util.HashMap;

public class Produto extends ItemComercial {

    private String descricao;
    private Float preco;
    private Integer estoque;


    Produto( String nome, Funcionario funcionario, String descricao, Float preco, Integer estoque){
        super(nome, descricao, funcionario);

        this.descricao=descricao;
        this.preco=preco;
        this.estoque=estoque;
    }

    public void vender(){
        if(estoque<0){
            estoque--;
            /*
            IMPLEMENTAR
             */
        }
    }

    /*
    a impl
    + vender()
    + atualizarEstoque()

     */
}
