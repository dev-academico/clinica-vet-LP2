package model;

import java.util.Map;
import java.util.Scanner;

//adicionando modificações
abstract class ItemComercial {
    static private int contItem=0;

    private Integer id;
    private String nome;//talvez seja melhor final
    private String desc;

    ItemComercial(Integer id, String nome, String desc, Funcionario fnr){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        contItem++;
        //this.responsaveisServ.put(this.id, fnr); //movido para serviço
    }

    //ovr
    public abstract boolean aplicarDesconto(Double v);

    //Identifica um serviço e um responsável

    public boolean consumoItem(Cliente cl){
        /*
        CRIA UM RELATÓRIO A RESPEITO DO CONSUMO DO CLIENTE

        - parâmetros do 'cl': preço, data_hora, id do serviço/produto, nome do cliente, forma de pagamento

         */

        boolean cons=false;

        return cons;
    }
}